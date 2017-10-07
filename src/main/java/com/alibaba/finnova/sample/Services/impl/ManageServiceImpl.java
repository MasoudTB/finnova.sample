package com.alibaba.finnova.sample.Services.impl;

import com.alibaba.finnova.sample.Domains.User;
import com.alibaba.finnova.sample.Exceptions.ServiceException;
import com.alibaba.finnova.sample.Services.ManageService;
import com.alibaba.finnova.sample.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements ManageService {
    private UserRepository userRepo;

    public ManageServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) throws ServiceException {
        if (user != null) {
            return userRepo.save(user);
        }
        throw new ServiceException("Connot Create User. User is null!");
    }

    @Override
    public void deleteUser(Long userId) throws ServiceException{
        if(userId != null)
        {
            userRepo.delete(userId);
        }
        throw new ServiceException("Cannot Delete User. UserId is null");
    }
}
