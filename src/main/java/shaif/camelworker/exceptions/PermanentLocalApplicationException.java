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
public class PermanentLocalApplicationException extends ApplicationException{
    public PermanentLocalApplicationException(String message){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Local,message);
    }

    public PermanentLocalApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Local, message, cause);
    }
    public PermanentLocalApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Local, cause);
    }
    
}
