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
public abstract class FatalApplicationException extends ApplicationException{

    public FatalApplicationException(ErrorKind errorKind, ErrorSource errorSource) {
        super(errorKind, errorSource);
    }

    public FatalApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message) {
        super(errorKind, errorSource, message);
    }

    public FatalApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message, Throwable cause) {
        super(errorKind, errorSource, message, cause);
    }

    public FatalApplicationException(ErrorKind errorKind, ErrorSource errorSource, Throwable cause) {
        super(errorKind, errorSource, cause);
    }

    public FatalApplicationException(ErrorSource errorSource, int transientTimeoutMillis) {
        super(errorSource, transientTimeoutMillis);
    }

    public FatalApplicationException(ErrorSource errorSource, int transientTimeoutMillis, String message) {
        super(errorSource, transientTimeoutMillis, message);
    }

    public FatalApplicationException(ErrorSource errorSource, int transientTimeoutMillis, String message, Throwable cause) {
        super(errorSource, transientTimeoutMillis, message, cause);
    }

    public FatalApplicationException(ErrorSource errorSource, int transientTimeoutMillis, Throwable cause) {
        super(errorSource, transientTimeoutMillis, cause);
    }
    
}
