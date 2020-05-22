package com.thinksee.provider.api.impl;

import com.thinksee.provider.api.HelloService;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class HelloServiceImpl implements HelloService {
    public String sayHello(String userName) {
        return "Hello : ";
    }
}
