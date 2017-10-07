package com.alibaba.finnova.sample.Services.impl;

import com.alibaba.finnova.sample.Domains.Order;
import com.alibaba.finnova.sample.Domains.User;
import com.alibaba.finnova.sample.Exceptions.ServiceException;
import com.alibaba.finnova.sample.Services.ShopService;
import com.alibaba.finnova.sample.repositories.OrderRepository;
import com.alibaba.finnova.sample.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService
{
    private OrderRepository orderRepo;
    private UserRepository userRepo;

    public ShopServiceImpl(OrderRepository orderRepo, UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }


    @Override
    public Order createOrder(Long userId, Order order) throws ServiceException {
        if(order != null) {
            User user = userRepo.findOne(userId);
            if (user != null) {
                order.setUser(user);
                return orderRepo.save(order);
            }
            throw new ServiceException("Cannot create order. User not found!");
        }
        throw new ServiceException("Cannot create order. Order is null!");
    }

    @Override
    public Order checkOrder(Long orderId) {
        return orderRepo.getOne(orderId);
    }

    @Override
    public void removeOrder(Long orderId)// throw ServiceException
    {
        if(orderId != null) {
            orderRepo.delete(orderId);
        }
        throw new ServiceException("Cannot delete order. OrderId is null!");
    }
}
