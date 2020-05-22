package com.thinksee.framework;

import com.thinksee.protocol.ProtocolType;
import com.thinksee.protocol.dubbo.DubboProtocol;
import com.thinksee.protocol.http.HttpProtocol;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class ProtocolFactory {
    public static Protocol getProtocol(final ProtocolType protocolType) {
//        String name = System.getProperty("protocolName");
//        if(name == null || name.equals("")) {
//            name = "http";
//        }
        if (protocolType == ProtocolType.HTTP) {
            return new HttpProtocol();
        } else if (protocolType == ProtocolType.DUBBO) {
            return new DubboProtocol();
        }
        return new HttpProtocol();
    }
}
