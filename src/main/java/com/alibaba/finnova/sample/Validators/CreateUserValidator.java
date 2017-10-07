package com.alibaba.finnova.sample.Validators;

import com.alibaba.finnova.sample.Exceptions.BadRequestException;
import com.alibaba.finnova.sample.Models.request.CreateUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CreateUserValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserValidator.class);
    private static final String EMPTY_DEFAUL_MESSAGE = "field cannot be empty";

    @Override
    public boolean supports(Class<?> clazz) {

        return CreateUserRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateUserRequest reqeust = (CreateUserRequest) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "fullName", EMPTY_DEFAUL_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email", EMPTY_DEFAUL_MESSAGE);

        if(errors.hasErrors())
        {
            LOGGER.error("Required fields cannot be empty:" + errors.getAllErrors().toString());
            throw new BadRequestException("required fields cannot be empty", errors);
        }

    }
}
