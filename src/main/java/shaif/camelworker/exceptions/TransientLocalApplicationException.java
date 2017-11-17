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
public class TransientLocalApplicationException extends TransientApplicationException{
    public TransientLocalApplicationException(String message){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Local, message);
    }
    public TransientLocalApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Local, message, cause);
    }
    public TransientLocalApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.Local, cause);
    }
    public TransientLocalApplicationException(long transientTimeoutMillis, String message) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.Local, transientTimeoutMillis, message);
    }

    public TransientLocalApplicationException(long transientTimeoutMillis, String message, Throwable cause) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.Local, transientTimeoutMillis, message, cause);
    }
    public TransientLocalApplicationException(long transientTimeoutMillis, Throwable cause) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.Local, transientTimeoutMillis, cause);
    }
    
}
