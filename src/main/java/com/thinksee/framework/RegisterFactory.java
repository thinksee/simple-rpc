package com.thinksee.framework;

import com.thinksee.protocol.ProtocolType;
import com.thinksee.protocol.dubbo.DubboProtocol;
import com.thinksee.protocol.http.HttpProtocol;
import com.thinksee.register.RegisterType;
import com.thinksee.register.RemoteMapRegister;
import com.thinksee.register.RemoteReigister;
import com.thinksee.register.ZookeeperRegister;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class RegisterFactory {
    public static RemoteReigister getRemoteRegister(final RegisterType registerType) {
//        String name = System.getProperty("protocolName");
//        if(name == null || name.equals("")) {
//            name = "http";
//        }
        if (registerType == RegisterType.ZOOKEEPER) {
            return new ZookeeperRegister();
        } else if (registerType == RegisterType.REMOTEMAP) {
            return new RemoteMapRegister();
        }
        return new RemoteMapRegister();
    }
}
