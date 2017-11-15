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
public class UnknownLocalApplicationException extends UnknownApplicationException{
    public UnknownLocalApplicationException(String message){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Local, message);
    }

    public UnknownLocalApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Local, message, cause);
    }
    public UnknownLocalApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Local, cause);
    }
    
}
