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
public class TransientExternalApplicationException extends TransientApplicationException{
    public TransientExternalApplicationException(String message){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.External, message);
    }
    public TransientExternalApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.External, message, cause);
    }
    public TransientExternalApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Transient, ApplicationException.ErrorSource.External, cause);
    }
    public TransientExternalApplicationException(long transientTimeoutMillis, String message) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.External, transientTimeoutMillis, message);
    }

    public TransientExternalApplicationException(long transientTimeoutMillis, String message, Throwable cause) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.External, transientTimeoutMillis, message, cause);
    }
    public TransientExternalApplicationException(long transientTimeoutMillis, Throwable cause) throws PermanentLocalApplicationException{
        super(ApplicationException.ErrorSource.External, transientTimeoutMillis, cause);
    }
    
}
