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
public class UnknownNetworkApplicationException extends ApplicationException{
    public UnknownNetworkApplicationException(String message){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Network, message);
    }

    public UnknownNetworkApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Network, message, cause);
    }
    public UnknownNetworkApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Unknown, ApplicationException.ErrorSource.Network, cause);
    }
    
}
