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
public class UnknownRemoteApplicationException extends ApplicationException{
    public UnknownRemoteApplicationException(String message){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Remote,message);
    }

    public UnknownRemoteApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Remote, message, cause);
    }
    public UnknownRemoteApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Remote, cause);
    }
    
}
