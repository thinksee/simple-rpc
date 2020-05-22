package com.thinksee.provider.api.impl;

import com.thinksee.provider.api.HelloService;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 * 服务端server端要实现这个接口。同时要发布这个接口，
 * 何谓发布这个接口？其实就是要像注册中心注册一下这个服务。
 * 这样，消费者在远程调用的时候可以通过注册中心注册的信息能够感知到服务。
 **/
public class HelloServiceImpl implements HelloService {
    public String sayHello(String userName) {
        return "Hello : " + userName;
    }
}
