/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shaif.camelworker.exceptions;

import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

/**
 *
 * @author if
 * 
 * All exception can be divided in 4 categories by 4 sources
 * Categories:
 *  <li>Fatal errors - nothing can be done, application shall shut down immediately, e.g. out of memory or internal storage is damaged. 
 *      Expected action is immediate application shutdown</li>
 *  <li>Permanent error - subsequenst calls to throwed method <b>will</b> throw exception again, e.g. sqrt(-1) in real numbers.
 *      Expected action - mark parameters as invalid; lets suppose we have a queue and process it calling some methon on each item.
 *      If method succeseed, then item should be removed, if method throws such exception, method should be placed aside in dead letters queue.
 *  </li>
 *  <li>Transient error - subsequenst calls to throwed method <b>may</b> complete successfully. Interval for next attempt can be specified.
 *      Expected action - for example above item should be placed aside into deferred queue to be processed later
 *  </li>
 *  <li>Unknown error - <b>method cannot decide</b> was required operation completed sucessfully or not, e.g. timeout when waiting a reply from
 *      remote server after some action was called, e.g. we call remote method to make a payments, but get a timeout, so we should mark payment as
 *      'in doubt'
 *  </li>
 * 
 *  Sources:
 *  <li>Local - source of error is application itself. NPE and so on</li>
 *  <li>External - source of error is local server, but application. For example, some required daemon is not running</li>
 *  <li>Netword - connection refused, connection closed by remote host, no dns entry...</li>
 *  <li>Remote - call to remote servise was not successful. Unauthorized, not enoigh funds, item not found, transaction declined etc.</li>
 * 
 *  Object which produced exception can be unstable after exception and becomes unusable.
 * 
 */
abstract public class ApplicationException extends Exception{

    public boolean isStable() {
        return stable;
    }

    public static ApplicationException handleRestClientException(RestClientException ex) throws PermanentRemoteApplicationException, TransientRemoteApplicationException, UnknownRemoteApplicationException, PermanentLocalApplicationException {
        if (ex instanceof HttpStatusCodeException) {
            HttpStatusCodeException httpEx = (HttpStatusCodeException) ex;
            switch (httpEx.getStatusCode()) {
                case NOT_FOUND:
                case GONE:
                case FORBIDDEN:
                case UNSUPPORTED_MEDIA_TYPE:
                    return new PermanentRemoteApplicationException(httpEx.getStatusText(), httpEx);
                case BAD_GATEWAY:
                case GATEWAY_TIMEOUT:
                case INSUFFICIENT_STORAGE:
                case SERVICE_UNAVAILABLE:
                case INTERNAL_SERVER_ERROR:
                    return new UnknownRemoteApplicationException("State of operation is unknown", ex);
            }
        } else if (ex instanceof UnknownHttpStatusCodeException) {
            return new UnknownRemoteApplicationException(String.format("Get unknown status code:%s", ((UnknownHttpStatusCodeException) ex).getRawStatusCode()), ex);
        } else if (ex instanceof ResourceAccessException) {
            ResourceAccessException rae = (ResourceAccessException) ex;
            if (rae.getCause() instanceof BindException) {
                return new TransientExternalApplicationException(5000, "Cannot bind", rae);
            } else if (rae.getCause() instanceof ConnectException) {
                return new TransientRemoteApplicationException(5000, "Cannot connect", rae);
            } else if (rae.getCause() instanceof NoRouteToHostException) {
                return new TransientRemoteApplicationException(5000, "No route to host", rae);
            } else if (rae.getCause() instanceof SocketException) {
                return new TransientExternalApplicationException(5000, "Cannot create socket", rae);
            } else if (rae.getCause() instanceof SocketTimeoutException) {
                return new UnknownRemoteApplicationException("Read timeout", rae);
            } else if (rae.getCause() instanceof URISyntaxException) {
                return new PermanentLocalApplicationException("Wrong URI syntax", rae);
            } else if (rae.getCause() instanceof UnknownHostException) {
                return new TransientRemoteApplicationException(3600000, "Cannot create socket", rae);
            } else if (rae.getCause() instanceof UnknownServiceException) {
                return new PermanentRemoteApplicationException("Unknown service", rae);
            }
        }
        return new UnknownLocalApplicationException("Unknown exception", ex);
    }

    public enum ErrorSource{
        Remote, Network, External, Local
    }
    public enum ErrorKind{
        Transient, Permanent, Unknown, Fatal
    }
    
    public ApplicationException(ErrorKind errorKind, ErrorSource errorSource){
        super();
        this.errorKind = errorKind;
        this.errorSource = errorSource;
    }

    public ApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message){
        super(message);
        this.errorKind = errorKind;
        this.errorSource = errorSource;
    }

    public ApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message, Throwable cause){
        super(message, cause);
        this.errorKind = errorKind;
        this.errorSource = errorSource;
    }

    public ApplicationException(ErrorKind errorKind, ErrorSource errorSource, Throwable cause){
        super(cause);
        this.errorKind = errorKind;
        this.errorSource = errorSource;
    }
    
    public ApplicationException(ErrorSource errorSource, int transientTimeoutMillis) throws PermanentLocalApplicationException{
        super();
        this.errorKind = ErrorKind.Transient;
        this.errorSource = errorSource;
        this.setTransientTimeoutMillis(transientTimeoutMillis);
    }

    public ApplicationException(ErrorSource errorSource, int transientTimeoutMillis, String message) throws PermanentLocalApplicationException{
        super(message);
        this.errorKind = ErrorKind.Transient;
        this.errorSource = errorSource;
        this.setTransientTimeoutMillis(transientTimeoutMillis);
    }
    
    public ApplicationException(ErrorSource errorSource, int transientTimeoutMillis, String message, Throwable cause) throws PermanentLocalApplicationException{
        super(message, cause);
        this.errorKind = ErrorKind.Transient;
        this.errorSource = errorSource;
        this.setTransientTimeoutMillis(transientTimeoutMillis);
    }

    public ApplicationException(ErrorSource errorSource, int transientTimeoutMillis, Throwable cause) throws PermanentLocalApplicationException{
        super(cause);
        this.errorKind = ErrorKind.Transient;
        this.errorSource = errorSource;
        this.setTransientTimeoutMillis(transientTimeoutMillis);
    }
    
    private ErrorSource errorSource = ErrorSource.Local;
    private ErrorKind errorKind = ErrorKind.Permanent;
    
    private int transientTimeoutMillis = 0;
    private boolean stable=true;

    protected void setStable(boolean stable) {
        this.stable = stable;
    }
    
    public void setUnstable() {
        setStable(false);
    }

    public int getTransientTimeoutMillis() throws PermanentLocalApplicationException {
        if(isTransient()){
            return transientTimeoutMillis;
        }
        throw new PermanentLocalApplicationException("timeout can be get only for transient errors");
    }

    public void setTransientTimeoutMillis(int transientTimeoutMillis) throws PermanentLocalApplicationException {
        if(transientTimeoutMillis<0){
            throw new PermanentLocalApplicationException("timeout must be >=0");
        }
        if(isTransient()){
            this.transientTimeoutMillis = transientTimeoutMillis;
        }
        throw new PermanentLocalApplicationException("timeout can be set only for transient errors");
    }

    public ErrorSource getErrorSource() {
        return errorSource;
    }

    public void setErrorSource(ErrorSource errorSource) {
        this.errorSource = errorSource;
    }

    public ErrorKind getErrorKind() {
        return errorKind;
    }

    public void setErrorKind(ErrorKind errorKind) {
        this.errorKind = errorKind;
    }    
    
    public boolean isLocal(){
        return errorSource == ErrorSource.Local;
    }

    public boolean isExternal(){
        return errorSource == ErrorSource.External;
    }
    
    public boolean isNetwork(){
        return errorSource == ErrorSource.Network;
    }

    public boolean isRemote(){
        return errorSource == ErrorSource.Remote;    
    }
    
    public boolean isTransient(){
        return errorKind==ErrorKind.Transient;
    }

    public boolean isPermanent(){
        return errorKind==ErrorKind.Permanent;
    }

    public boolean isUnknown(){
        return errorKind==ErrorKind.Unknown;
    }
    
    public boolean isFatal(){
        return errorKind==ErrorKind.Fatal;
    }
}
