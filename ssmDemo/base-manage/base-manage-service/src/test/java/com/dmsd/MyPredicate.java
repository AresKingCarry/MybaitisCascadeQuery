package com.dmsd;

/**
 * Created by Ares on 2018/3/5.
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
