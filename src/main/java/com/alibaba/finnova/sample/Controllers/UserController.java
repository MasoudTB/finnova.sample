package com.alibaba.finnova.sample.Domains;

import com.alibaba.finnova.sample.Models.request.CreateUserRequest;
import com.alibaba.finnova.sample.Validators.CreateUserValidator;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private ModelMapper mapper;
    private CreateUserValidator createUserValidator;

    public UserController(ModelMapper modelMapper, CreateUserValidator createUserValidator) {
        this.mapper = modelMapper;
        this.createUserValidator = createUserValidator;
    }

    @InitBinder("createUserRequest")
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(createUserValidator);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@Valid @RequestBody CreateUserRequest createUserRequest)
    {
        User user = mapper.map(createUserRequest, User.class);

        return new ResponseEntity(HttpStatus.OK);
    }
}
