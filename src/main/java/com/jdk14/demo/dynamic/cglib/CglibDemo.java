package com.jdk14.demo.dynamic.cglib;


import com.jdk14.demo.dynamic.jdk.Zhangsan;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDemo {


    public static void main(String[] args) {

        Enhancer  enhancer = new Enhancer();

        enhancer.setSuperclass(Zhangsan.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println(method);

                System.out.println("before");
                Object res = methodProxy.invokeSuper(o, args);
                System.out.println("after");
                return res;
            }
        });

        Zhangsan zhangsan = (Zhangsan) enhancer.create();

        zhangsan.findObject();
    }

}
