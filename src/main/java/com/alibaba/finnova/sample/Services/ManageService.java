package com.alibaba.finnova.sample.Services;

import com.alibaba.finnova.sample.Domains.User;

public interface ManageService {
    User createUser(User user);
    void deleteUser(Long userId);
}
