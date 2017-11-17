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
public class TransientNetworkApplicationException extends TransientApplicationException{
    public TransientNetworkApplicationException(String message){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Network, message);
    }
    public TransientNetworkApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Network, message, cause);
    }
    public TransientNetworkApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Network, cause);
    }
    public TransientNetworkApplicationException(int transientTimeoutMillis) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.Network, transientTimeoutMillis);
    }
    public TransientNetworkApplicationException(int transientTimeoutMillis, String message) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.Network, transientTimeoutMillis, message);
    }

    public TransientNetworkApplicationException(int transientTimeoutMillis, String message, Throwable cause) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.Network, transientTimeoutMillis, message, cause);
    }
    public TransientNetworkApplicationException(int transientTimeoutMillis, Throwable cause) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.Network, transientTimeoutMillis, cause);
    }
    
}
