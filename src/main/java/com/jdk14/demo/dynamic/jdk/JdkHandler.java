package com.jdk14.demo.dynamic.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkHandler implements InvocationHandler {

    private Object target;

    JdkHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");

        method.invoke(target,null);

        System.out.println("before");

        return null;
    }
}
