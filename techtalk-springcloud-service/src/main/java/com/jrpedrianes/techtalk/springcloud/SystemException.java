package com.jrpedrianes.techtalk.springcloud;

import java.util.Collections;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * This class is used for reporting application level exceptions.
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 5207074660739579569L;

    private boolean logged = false;
    private String errorCode = null;
    private Errors errors = null;

    /**
     * Constructs a new SystemException with {@code null} as its
     * detail message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #withCause}.
     */
    public SystemException() {
        super();
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     */
    public SystemException(String message) {
        super(message);
    }

    /**
     * @param cause the cause.
     */
    public SystemException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param cause the cause.
     */
    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param errorCode
     *            Well defined error code for the error type. Used in logs and
     *            for translation to user messages.
     */
    public SystemException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param errorCode
     *            Well defined error code for the error type. Used in logs and
     *            for translation to user messages.
     */
    public SystemException(String message, Enum<?> errorCode) {
        super(message);
        this.errorCode = (errorCode == null ? null : errorCode.name());
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param errorCode
     *            Well defined error code for the error type. Used in logs and
     *            for translation to user messages.
     * @param cause the cause.
     */
    public SystemException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param errorCode
     *            Well defined error code for the error type. Used in logs and
     *            for translation to user messages.
     * @param cause the cause.
     */
    public SystemException(String message, Enum<?> errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = (errorCode == null ? null : errorCode.name());
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param errorCode
     *            Well defined error code for the error type. Used in logs and
     *            for translation to user messages.
     * @param errors Errors produced.
     */
    public SystemException(String message, String errorCode, Errors errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param errorCode
     *            Well defined error code for the error type. Used in logs and
     *            for translation to user messages.
     */
    public SystemException(String message, Enum<?> errorCode, Errors errors) {
        super(message);
        this.errorCode = (errorCode == null ? null : errorCode.name());
        this.errors = errors;
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param errorCode
     *            Well defined error code for the error type. Used in logs and
     *            for translation to user messages.
     * @param errors Errors produced
     * @param cause the cause.
     */
    public SystemException(String message, String errorCode, Errors errors, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    /**
     * @param message the detail message (which is saved for later retrieval
     *            by the {@link #getMessage()} method).
     * @param errorCode
     *            Well defined error code for the error type. Used in logs and
     *            for translation to user messages.
     * @param errors Errors produced
     * @param cause the cause.
     */
    public SystemException(String message, Enum<?> errorCode, Errors errors, Throwable cause) {
        super(message, cause);
        this.errorCode = (errorCode == null ? null : errorCode.name());
        this.errors = errors;
    }

    /**
     * Get errors
     *
     * @return List of {@link ObjectError} instances
     */
    public List<ObjectError> getAllErrors() {
        if (!hasErrors()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(errors.getAllErrors());
    }

    /**
     * Return if there were any errors.
     */
    public boolean hasErrors() {
        return errors != null && errors.hasErrors();
    }
    /**
     * Return the total number of errors.
     */
    public int getErrorCount() {
        if (!hasErrors()) {
            return 0;
        }
        return errors.getErrorCount();
    }

    /**
     * Get all errors associated with a field.
     *
     * @return a List of {@link FieldError} instances
     */
    public List<FieldError> getFieldErrors() {
        if (!hasErrors()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(errors.getFieldErrors());
    }

    /**
     * Well defined error code for the error type. Used in logs and for
     * translation to user messages.
     */
    public String getErrorCode() {
        return errorCode;
    }
    /**
     * This flag indicates that the exception has been logged. Used to avoid
     * duplicate logging of the same error.
     */
    public boolean isLogged() {
        return logged;
    }

    /**
     * @see #isLogged()
     */
    public SystemException logged() {
        logged = true;
        return this;
    }

    /**
     * Initializes the <i>cause</i> of this throwable to the specified value.
     */
    public SystemException withCause(Throwable cause) {
        super.initCause(cause);
        return this;
    }

    /**
     * Initializes the error code
     *
     * @param errorCode Well defined error code for the error type. Used in logs and for translation to user messages.
     */
    public SystemException withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * Initializes the error code
     *
     * @param errorCode Well defined error code for the error type. Used in logs and for translation to user messages.
     */
    public SystemException withErrorCode(Enum<?> errorCode) {
        this.errorCode = (errorCode == null ? null : errorCode.name());
        return this;
    }

    /**
     * Initializes the errors produced
     *
     * @param errors Errors produced.
     */
    public SystemException withErrors(Errors errors) {
        this.errors = errors;
        return this;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[" + getErrorCode() + "]:" + getMessage() + " Errors: " + getAllErrors();
    }
}