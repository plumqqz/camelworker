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
public abstract class TransientApplicationException extends ApplicationException implements BrokenObjects {

    public TransientApplicationException(ErrorKind errorKind, ErrorSource errorSource) {
        super(errorKind, errorSource);
    }

    public TransientApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message) {
        super(errorKind, errorSource, message);
    }

    public TransientApplicationException(ErrorKind errorKind, ErrorSource errorSource, String message, Throwable cause) {
        super(errorKind, errorSource, message, cause);
    }

    public TransientApplicationException(ErrorKind errorKind, ErrorSource errorSource, Throwable cause) {
        super(errorKind, errorSource, cause);
    }

    public TransientApplicationException(ErrorSource errorSource, long transientTimeoutMillis) throws PermanentLocalApplicationException {
        super(errorSource, transientTimeoutMillis);
    }

    public TransientApplicationException(ErrorSource errorSource, long transientTimeoutMillis, String message) throws PermanentLocalApplicationException {
        super(errorSource, transientTimeoutMillis, message);
    }

    public TransientApplicationException(ErrorSource errorSource, long transientTimeoutMillis, String message, Throwable cause) throws PermanentLocalApplicationException {
        super(errorSource, transientTimeoutMillis, message, cause);
    }

    public TransientApplicationException(ErrorSource errorSource, long transientTimeoutMillis, Throwable cause) throws PermanentLocalApplicationException {
        super(errorSource, transientTimeoutMillis, cause);
    }
        
}
