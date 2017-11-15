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
public class FatalNetworkApplicationException extends FatalApplicationException{
    public FatalNetworkApplicationException(String message){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Network, message);
    }

    public FatalNetworkApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Network, message, cause);
    }
    public FatalNetworkApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Fatal, ApplicationException.ErrorSource.Network, cause);
    }
    
}
