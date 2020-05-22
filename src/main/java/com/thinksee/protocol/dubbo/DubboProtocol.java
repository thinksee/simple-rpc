package com.thinksee.protocol.dubbo;

import com.thinksee.framework.Invocation;
import com.thinksee.framework.Protocol;
import com.thinksee.framework.URL;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class DubboProtocol implements Protocol {
    public void start(URL url) throws InterruptedException {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(url.getHostname(), url.getPort());
    }

    public String send(URL url, Invocation invocation) throws InterruptedException {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHostname(),url.getPort(), invocation);
    }
}
