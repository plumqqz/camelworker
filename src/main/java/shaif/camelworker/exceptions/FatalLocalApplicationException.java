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
public class FatalLocalApplicationException extends FatalApplicationException{
    public FatalLocalApplicationException(String message){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Local, message);
    }

    public FatalLocalApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Local, message, cause);
    }
    public FatalLocalApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Local, cause);
    }
    
}
