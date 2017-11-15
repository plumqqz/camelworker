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
public class PermanentNetworkApplicationException extends PermanentApplicationException{
    public PermanentNetworkApplicationException(String message){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Network,message);
    }

    public PermanentNetworkApplicationException(String message, Throwable cause){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Network, message, cause);
    }
    public PermanentNetworkApplicationException(Throwable cause){
        super(ApplicationException.ErrorKind.Permanent, ApplicationException.ErrorSource.Network, cause);
    }
    
}
