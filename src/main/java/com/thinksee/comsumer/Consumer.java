package com.thinksee.comsumer;

import com.thinksee.framework.BalanceRamdom;
import com.thinksee.framework.ProxyFactory;
import com.thinksee.protocol.ProtocolType;
import com.thinksee.provider.api.HelloService;
import com.thinksee.register.RegisterType;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class Consumer {
    public static void main(String[] args) throws InterruptedException {
        // jvm参数 -DprotocolName=dubbo -Dmock=return:123
        HelloService helloService = ProxyFactory.getProxy(ProtocolType.HTTP, RegisterType.REMOTEMAP, HelloService.class, new BalanceRamdom());
        System.out.println(helloService);
        while (true) {
            String result = helloService.sayHello("think see");
            System.out.println("result : " + result);
            Thread.sleep(1000);
        }
    }
}
