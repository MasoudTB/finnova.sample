package com.alibaba.finnova.sample.Controllers;

import com.alibaba.finnova.sample.Exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    private final static String ERRORS = "errors";
    private final static String ERROR = "error";

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handlerBadRequestException(
            BadRequestException badRequestException) {
        Map<String, Object> result = createErrorResponse(badRequestException.getErrors());
        if(result.size() == 0){
            result.put(ERROR, badRequestException.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    private Map<String, Object> createErrorResponse(Errors errors)
    {
        Map<String, Object> result = new HashMap<>();
        Map<String, String> errorResults = new HashMap<>();

        if(errors != null){
            ///int i = 0;
            for(ObjectError error: errors.getAllErrors()) {
                errorResults.put(error.getCode(), error.getDefaultMessage());
                //i++;
            }
            result.put(ERRORS, errorResults);
        }
        return result;
    }
}
