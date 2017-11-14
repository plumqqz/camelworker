/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shaif.camelworker.exceptions;

/**
 *
 * @author if
 */
abstract public class ApplicationException extends RuntimeException{

    public enum ErrorSource{
        Remote, Network, Local
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
    
    public ApplicationException(ErrorSource errorSource, int transientTimeoutMillis){
        super();
        this.errorKind = ErrorKind.Transient;
        this.errorSource = errorSource;
        this.setTransientTimeoutMillis(transientTimeoutMillis);
    }

    public ApplicationException(ErrorSource errorSource, int transientTimeoutMillis, String message){
        super(message);
        this.errorKind = ErrorKind.Transient;
        this.errorSource = errorSource;
        this.setTransientTimeoutMillis(transientTimeoutMillis);
    }
    
    public ApplicationException(ErrorSource errorSource, int transientTimeoutMillis, String message, Throwable cause){
        super(message, cause);
        this.errorKind = ErrorKind.Transient;
        this.errorSource = errorSource;
        this.setTransientTimeoutMillis(transientTimeoutMillis);
    }

    public ApplicationException(ErrorSource errorSource, int transientTimeoutMillis, Throwable cause){
        super(cause);
        this.errorKind = ErrorKind.Transient;
        this.errorSource = errorSource;
        this.setTransientTimeoutMillis(transientTimeoutMillis);
    }
    
    private ErrorSource errorSource = ErrorSource.Local;
    private ErrorKind errorKind = ErrorKind.Permanent;
    
    private int transientTimeoutMillis = 0;

    public int getTransientTimeoutMillis() {
        if(isTransient()){
            return transientTimeoutMillis;
        }
        throw new PermanentLocalApplicationException("timeout can be get only for transient errors");
    }

    public void setTransientTimeoutMillis(int transientTimeoutMillis) {
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
