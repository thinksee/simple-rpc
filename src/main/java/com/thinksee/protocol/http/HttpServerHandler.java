package com.thinksee.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.thinksee.framework.Invocation;
import com.thinksee.provider.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class HttpServerHandler {
    public void handler(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 使用fastjson工具使流中读取的数据反序列化成实体类
        Invocation invocation = JSONObject.parseObject(request.getInputStream(), Invocation.class);
        // 获取服务的名字
        String interfaceName = invocation.getInterfaceName();
        // 从注册中心拿到接口实现类
        Class impClass = LocalRegister.get(interfaceName);
        // 获取类的方法
        Method method = impClass.getMethod(invocation.getMethodName(), invocation.getParamType());
        // 反射调用类的方法并把结果返回
        String result = (String) method.invoke(impClass.newInstance(), invocation.getParams());
        System.out.println("tomcat:" + result);
        IOUtils.write(result, response.getOutputStream());
    }
}
