package com.dmsd.service;

import com.dmsd.api.OrderService;
import com.dmsd.dao.OrdersMapper;
import com.dmsd.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ares on 2018/3/6.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;


    @Override
    public List<Orders> queryOrdersAndOrderDetailAndItems() {
        return ordersMapper.queryOrdersAndOrderDetailAndItems();
    }

    @Override
    public List<Orders> queryOrdersAndOrderDetailMap() {
        return ordersMapper.queryOrdersAndOrderDetailMap();
    }

    @Override
    public List<Orders> queryOrderMap() {
        return ordersMapper.queryOrderMap();
    }
}
