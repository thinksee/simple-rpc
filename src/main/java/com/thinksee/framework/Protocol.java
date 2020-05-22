package com.thinksee.framework;

import org.apache.catalina.LifecycleException;

import java.io.IOException;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public interface Protocol {
    void start(URL url) throws LifecycleException, InterruptedException;
    String send(URL url, Invocation invocation) throws IOException, InterruptedException;
}
