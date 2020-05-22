package com.thinksee.protocol.dubbo;

import com.thinksee.framework.Invocation;
import com.thinksee.provider.LocalRegister;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation) msg;
        System.out.println("invocation" + invocation);
        Class serviceImpl = LocalRegister.get(invocation.getInterfaceName());

        Method method = serviceImpl.getMethod(invocation.getMethodName(), invocation.getParamType());
        Object result = method.invoke(serviceImpl.newInstance(), invocation.getParams());
        System.out.println("Netty----------" + result.toString());
        ctx.writeAndFlush("Netty:" + result);
    }
}
