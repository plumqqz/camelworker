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
public class OkApplicationException extends ApplicationException{

    public OkApplicationException(ErrorKind errorKind, ErrorSource errorSource) {
        super(errorKind, errorSource);
        setUnstable();
    }

    public OkApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message) {
        super(errorKind, errorSource, message);
        setUnstable();
    }

    public OkApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message, Throwable cause) {
        super(errorKind, errorSource, message, cause);
        setUnstable();
    }

    public OkApplicationException(ErrorKind errorKind, ErrorSource errorSource, Throwable cause) {
        super(errorKind, errorSource, cause);
        setUnstable();
    }
}
