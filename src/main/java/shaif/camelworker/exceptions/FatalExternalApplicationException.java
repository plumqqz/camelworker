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
public class FatalExternalApplicationException extends FatalApplicationException{
    public FatalExternalApplicationException(String message){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.External, message);
    }

    public FatalExternalApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.External, message, cause);
    }
    public FatalExternalApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.External, cause);
    }
    
}
