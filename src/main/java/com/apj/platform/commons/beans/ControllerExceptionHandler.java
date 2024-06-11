package com.apj.platform.commons.beans;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.apj.platform.commons.constants.AuthErrorCodes;
import com.apj.platform.commons.vo.ApiError;
import com.apj.platform.commons.vo.SystemException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    private final MessageSource messageSource;

    public ControllerExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handleValidationExceptions(
            MethodArgumentNotValidException ex, Locale locale) {
        ApiError apiError = new ApiError();
        apiError.setErrorCode(AuthErrorCodes.ERR_INPUT_VALIDATION);
        apiError.setErrMessage(messageSource.getMessage(apiError.getErrorCode(), null, locale));
        Map<String, ApiError> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            ApiError se = new ApiError();
            se.setErrorCode(error.getDefaultMessage());
            se.setErrMessage(messageSource.getMessage(se.getErrorCode(), null, locale));
            errors.put(fieldName, se);
        });
        apiError.setParams(errors);
        return apiError;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public ApiError handleInvalidDateExceptions(
            DateTimeParseException ex, Locale locale) {
        ApiError apiError = new ApiError();
        apiError.setErrorCode(AuthErrorCodes.ERR_INPUT_VALIDATION);
        apiError.setErrMessage(messageSource.getMessage(apiError.getErrorCode(), null, locale));
        Map<String, ApiError> errors = new HashMap<>();
        errors.put("date", apiError);
        apiError.setParams(errors);
        return apiError;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SystemException.class)
    public ApiError handleExceptions(
            SystemException ex, Locale locale) {
        ApiError apiError = new ApiError();
        apiError.setErrorCode(ex.getErrorcode());
        apiError.setErrMessage(messageSource.getMessage(apiError.getErrorCode(),
                null != ex.params ? ex.params.toArray() : null, locale));
        apiError.setParams(ex.params);
        log.error(apiError.toString());
        log.debug(apiError.toString(), ex);
        return apiError;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BadCredentialsException.class)
    public ApiError handleExceptions(
            BadCredentialsException ex, Locale locale) {
        ApiError apiError = new ApiError();
        apiError.setErrorCode(AuthErrorCodes.ERR_BAD_CREDENTIALS);
        apiError.setErrMessage(messageSource.getMessage(apiError.getErrorCode(),
                null, locale));
        log.error(apiError.toString());
        log.debug(apiError.toString(), ex);
        return apiError;
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ApiError handleMissingRequireParametersDateExceptions(
            MissingServletRequestParameterException ex, Locale locale) {
        ApiError apiError = new ApiError();
        apiError.setErrorCode(AuthErrorCodes.ERR_INPUT_VALIDATION);
        apiError.setErrMessage(messageSource.getMessage(apiError.getErrorCode(), null, locale));
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        apiError.setParams(errors);
        return apiError;
    }
}
