package com.dmsd;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Ares on 2018/3/5.
 */
public class TestInter {

    //供给接口：
    //需求：生成指定个数的整数，并放到集合中
    @Test
    public void TestSupplier(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 1000));
        for (Integer i :numList){
            System.out.println(i);
        }
    }

    public List<Integer> getNumList(int num , Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();

       for (int i=1;i<=num;i++){
           Integer integer = sup.get();
           list.add(integer);
       }
        return list;
    }



    //消费接口：
}
