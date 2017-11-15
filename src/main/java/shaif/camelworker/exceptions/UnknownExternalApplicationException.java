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
public class UnknownExternalApplicationException extends UnknownApplicationException{
    public UnknownExternalApplicationException(String message){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.External, message);
    }

    public UnknownExternalApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.External, message, cause);
    }
    public UnknownExternalApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.External, cause);
    }
    
}
