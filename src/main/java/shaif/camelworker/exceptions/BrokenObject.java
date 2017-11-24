/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shaif.camelworker.exceptions;

import java.util.Optional;

/**
 *
 * @author if
 */
class BrokenObject {
    final private Object object;
    final private String message;
    final private Throwable cause;

    public BrokenObject(Object object, String message) {
        this.object = object;
        this.message = message;
        this.cause = null;
    }

    public BrokenObject(Object object, String message, Throwable cause) {
        this.object = object;
        this.message = message;
        this.cause = cause;
    }
    
    public Object getObject() {
        return object;
    }

    public String getMessage() {
        return message;
    }

    public Optional<Throwable> getCause() {
        return Optional.of(cause);
    }

}
