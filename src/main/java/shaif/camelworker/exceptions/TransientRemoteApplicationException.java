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
public class TransientRemoteApplicationException extends TransientApplicationException{
    public TransientRemoteApplicationException(String message){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Remote, message);
    }
    public TransientRemoteApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Remote, message, cause);
    }
    public TransientRemoteApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Remote, cause);
    }
    public TransientRemoteApplicationException(int transientTimeoutMillis){
        super(ApplicationException.ErrorSource.Remote, transientTimeoutMillis);
    }
    public TransientRemoteApplicationException(int transientTimeoutMillis, String message){
        super(ApplicationException.ErrorSource.Remote, transientTimeoutMillis, message);
    }

    public TransientRemoteApplicationException(int transientTimeoutMillis, String message, Throwable cause){
        super(ApplicationException.ErrorSource.Remote, transientTimeoutMillis, message, cause);
    }
    public TransientRemoteApplicationException(int transientTimeoutMillis, Throwable cause){
        super(ApplicationException.ErrorSource.Remote, transientTimeoutMillis, cause);
    }
    
}
