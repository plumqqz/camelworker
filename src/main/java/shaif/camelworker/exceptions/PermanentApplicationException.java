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
public abstract class PermanentApplicationException extends ApplicationException{

    public PermanentApplicationException(ErrorKind errorKind, ErrorSource errorSource) {
        super(errorKind, errorSource);
    }

    public PermanentApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message) {
        super(errorKind, errorSource, message);
    }

    public PermanentApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message, Throwable cause) {
        super(errorKind, errorSource, message, cause);
    }

    public PermanentApplicationException(ErrorKind errorKind, ErrorSource errorSource, Throwable cause) {
        super(errorKind, errorSource, cause);
    }

    public PermanentApplicationException(ErrorSource errorSource, int transientTimeoutMillis) {
        super(errorSource, transientTimeoutMillis);
    }

    public PermanentApplicationException(ErrorSource errorSource, int transientTimeoutMillis, String message) {
        super(errorSource, transientTimeoutMillis, message);
    }

    public PermanentApplicationException(ErrorSource errorSource, int transientTimeoutMillis, String message, Throwable cause) {
        super(errorSource, transientTimeoutMillis, message, cause);
    }

    public PermanentApplicationException(ErrorSource errorSource, int transientTimeoutMillis, Throwable cause) {
        super(errorSource, transientTimeoutMillis, cause);
    }
       
}
