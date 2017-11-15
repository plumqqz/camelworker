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
public class FatalRemoteApplicationException extends FatalApplicationException{
    public FatalRemoteApplicationException(String message){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Remote, message);
    }

    public FatalRemoteApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Remote, message, cause);
    }
    public FatalRemoteApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Remote, cause);
    }    
}
