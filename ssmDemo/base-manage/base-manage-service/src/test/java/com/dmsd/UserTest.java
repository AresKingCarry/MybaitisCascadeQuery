package com.dmsd;

import com.dmsd.pojo.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ares on 2018/3/4.
 */
public class UserTest {

    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.99),
            new Employee(102,"李四",13,4444.66),
            new Employee(103,"王五",14,3000.99),
            new Employee(104,"赵六",55,20000.99),
            new Employee(105,"田七",66,55555.55),
            new Employee(106,"周八",77,99.99)
            );

    //需求1：获取公司中年龄小于30的员工信息

    public List<Employee> filterEmployeeAge(List<Employee> emps){
        List<Employee> list = new ArrayList<Employee>();

        for (Employee emp : emps){
            if (emp.getAge()<30){
                list.add(emp);
            }
        }
        return list;
    }

    @Test
    public void test1(){
        List<Employee> employees = filterEmployeeAge(emps);
        for (Employee employee :employees){
            System.out.println(employee);
        }
    }

    //需求2：获取公司中工资大于5000的员工信息
    public List<Employee> filterEmployeeSalary(List<Employee> emps){
        List<Employee> list = new ArrayList<Employee>();

        for (Employee emp : emps){
            if (emp.getSalary()>5000){
                list.add(emp);
            }
        }
        return list;
    }
    @Test
    public void test2(){
        List<Employee> employees = filterEmployeeSalary(emps);
        for (Employee employee :employees){
            System.out.println(employee);
        }
    }


    public List<Employee> filterEmployee(List<Employee> emps,MyPredicate<Employee> mp){
        List<Employee> list = new ArrayList<Employee>();

        for (Employee emp : emps){
            if (mp.test(emp)){
                list.add(emp);
            }
        }
        return list;
    }
    //优化方式1：策略模式
    @Test
    public void test3(){
        List<Employee> employees = filterEmployee(emps, new FilterEmployeeForSalary());
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }

    //优化方式2：内部类
    @Test
    public void test4(){
        List<Employee> employees = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 5000;
            }
        });
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }

    //优化3：Lambda表达式
    @Test
    public void test5(){
        List<Employee> employees = filterEmployee(emps, (x) -> x.getSalary() > 5000);
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }

    //优化4：Stream API
    @Test
    public void test6(){
        emps.stream().filter(e -> e.getSalary()>5000).forEach(System.out::println);

        System.out.println("---------------------------------------------------");

        emps.stream().filter(e -> e.getSalary()>5000).map(Employee::getName).limit(2).sorted().forEach(System.out::println);
    }


}
