package com.alibaba.finnova.sample.Adaptors;

import com.alibaba.finnova.sample.Domains.User;
import com.alibaba.finnova.sample.Models.request.CreateUserRequest;
import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

public class CreateUserRequestAdaptor extends ConverterConfigurerSupport<CreateUserRequest, User> {

    @Override
    protected Converter<CreateUserRequest, User> converter() {
        return new AbstractConverter<CreateUserRequest, User>() {
            @Override
            protected User convert(CreateUserRequest source) {
                User user = new User();
                String[] name = source.getFullName().split(",");

                user.setFirstName(name[0]);
                user.setLastName(name[1]);
                user.setEmail(source.getEmail());

                return user;
            }
        };
    }
}
