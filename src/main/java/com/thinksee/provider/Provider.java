package com.thinksee.provider;

import com.thinksee.framework.Protocol;
import com.thinksee.framework.ProtocolFactory;
import com.thinksee.framework.URL;
import com.thinksee.protocol.ProtocolType;
import com.thinksee.protocol.http.HttpServer;
import com.thinksee.provider.api.HelloService;
import com.thinksee.provider.api.impl.HelloServiceImpl;
import com.thinksee.register.RemoteMapRegister;
import com.thinksee.register.ZookeeperRegister;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class Provider {
    private static boolean isRun = true;

    public static void main(String[] args) throws Exception {
        // jvm参数 -DprotocolName=dubbo -Dport=8082  Integer.valueOf(System.getProperty("port"))
        URL url = new URL("localhost", 8082);
        // 远程服务注册地址
//        ZookeeperRegister.regist(HelloService.class.getName(), url);
        new RemoteMapRegister().regist(HelloService.class.getName(), url);
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);
        // 本地注册服务的实现类
        Protocol protocol = ProtocolFactory.getProtocol(ProtocolType.HTTP);
        protocol.start(url);

//        HttpServer httpServer = new HttpServer();
//        httpServer.start("localhost", 8080);
    }
}
