package com.thinksee.framework;

import com.thinksee.protocol.ProtocolType;
import com.thinksee.provider.api.HelloService;
import com.thinksee.register.RegisterType;
import com.thinksee.register.RemoteMapRegister;
import com.thinksee.register.ZookeeperRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 *
 * 通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，
 * 它并不是我们的InvocationHandler类型，也不是我们定义的那组接口的类型，
 * 而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，
 * 以$开头，proxy为中，最后一个数字表示对象的标号。
 **/
public class ProxyFactory {

    public static <T> T getProxy(final ProtocolType protocolType,
                                 final RegisterType registerType,
                                 final Class interfaceClass,
                                 BalanceStrategy balanceStrategy
    ) {
//        public static Object newProxyInstance(ClassLoader loader,
//                Class<?>[] interfaces,
//                InvocationHandler h)
        // 这里配置的是虚拟机参数 -DprotocolName=dubbo -Dmock=return:123
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                String mock = System.getProperty("mock");
//                if (mock.startsWith("return:")) {
//                    String result = mock.replace("return", "");
//                    return result;
//                }
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), args, method.getParameterTypes());
                System.out.println("Invocation: " + invocation);
                URL url = new StrategyContext(balanceStrategy).executeStrategy(RegisterFactory.getRemoteRegister(registerType).get(interfaceClass.getName()));

                System.out.println("URL:" + url);
                Protocol protocol = ProtocolFactory.getProtocol(protocolType);
                return protocol.send(url, invocation);
            }
        });
    }
}
