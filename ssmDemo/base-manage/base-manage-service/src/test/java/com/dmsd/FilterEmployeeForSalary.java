package com.dmsd;

import com.dmsd.pojo.Employee;

/**
 * Created by Ares on 2018/3/5.
 */
public class FilterEmployeeForSalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary()>5000;
    }
}
