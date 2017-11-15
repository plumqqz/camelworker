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
public class PermanentExternalApplicationException extends PermanentApplicationException{
    public PermanentExternalApplicationException(String message){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.External,message);
    }

    public PermanentExternalApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.External, message, cause);
    }
    public PermanentExternalApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.External, cause);
    }
    
}
