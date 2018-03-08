package com.dmsd;

import com.dmsd.api.OrderService;
import com.dmsd.pojo.Orders;
import com.dmsd.testUtil.CommonFacade;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * Created by Ares on 2018/3/6.
 */
public class OrderTest extends CommonFacade {


    /**
     * 关联查询用户和订单
     */
    @Test
    public void testqueryOrdersAndOrderDetailAndItems(){
        List<Orders> orders = orderService.queryOrdersAndOrderDetailAndItems();
        System.out.println(orders);
    }


    /**
     * 关联查询订单和订单明细，一个订单可以有多个订单明细
     */
    @Test
    public void testqueryOrdersAndOrderDetailMap(){
        List<Orders> orders = orderService.queryOrdersAndOrderDetailMap();
        System.out.println(orders);
    }

    @Test
    public void testqueryOrderMap(){
        List<Orders> ordersList = orderService.queryOrderMap();
        System.out.println(ordersList);
    }



}
