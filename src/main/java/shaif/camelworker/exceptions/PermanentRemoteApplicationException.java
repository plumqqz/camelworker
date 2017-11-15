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
public class PermanentRemoteApplicationException extends PermanentApplicationException{
    public PermanentRemoteApplicationException(String message){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Remote,message);
    }

    public PermanentRemoteApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Remote, message, cause);
    }
    public PermanentRemoteApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Remote, cause);
    }
    
}
