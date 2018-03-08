package com.dmsd;

import com.dmsd.pojo.Employee;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ares on 2018/3/5.
 */
public class TestLambda {
    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.99),
            new Employee(102,"李四",18,4444.66),
            new Employee(103,"王五",14,3000.99),
            new Employee(104,"赵六",55,20000.99),
            new Employee(105,"田七",66,55555.55),
            new Employee(106,"周八",77,99.99)
    );
    private TestLong t;

    //先比较年龄，如果年龄相同，就比较序号，由序号排序；如果年龄不相同，就比较年龄，按年龄排序
    @Test
    public void test1(){
        Collections.sort(emps,(e1,e2) -> {
            if (e1.getAge()==e2.getAge()){
                return -Integer.compare(e1.getId(),e2.getId());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee employee :emps){
            System.out.println(employee);
        }
    }

    //调用自定义函数式接口，把字符串转换为大写
    @Test
    public void TestUpStr(){
        String str = "abcdefg";
        String upStr = UpStr(str, str1 -> str1.toUpperCase());
        System.out.println(upStr);

        System.out.println("----------------------------------------");

        String upStr1 = UpStr(str, str1 -> str1.substring(2, 4));
        System.out.println(upStr1);

    }

    public String UpStr(String str ,StrFilter sf){
        String value = sf.getValue(str);
        return value;
    }

    @Test
    public void testCount(){
        Long t1= 5L;
        Long t2=9L;
        long count = count(t1, t2, (l1, l2) -> l1 + l2);
        System.out.println(count);


        System.out.println("---------------------------------------");

        long count1 = count(t1, t2, (l1, l2) -> l1 * l2);

        System.out.println(count1);
    }

    public long count(Long t1,Long t2,TestLong<Long,Long> t){

        Long aLong = t.count(t1, t2);
        return aLong;

    }


    @Test
    public void test2(){
        List books = new ArrayList();
        books.add("轻量级Java EE 企业应用实战");
        books.add("疯狂Java讲义1223344    ");
        books.add("疯狂Java讲义22");
        books.add("疯狂Java讲义3333");
        books.add("疯狂Java讲义44444");

        //根据字符串长度从小到大依次排序
        books.sort((b1,b2)->((String)b1).length()-((String)b2).length());
        System.out.println(books);

        //最直接用集合元素的长度作为新的集合元素
        books.replaceAll(ele->((String)ele).length());
        System.out.println(books);
    }





}
