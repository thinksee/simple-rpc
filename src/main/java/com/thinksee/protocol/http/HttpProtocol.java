package com.thinksee.protocol.http;

import com.thinksee.framework.Invocation;
import com.thinksee.framework.Protocol;
import com.thinksee.framework.URL;
import org.apache.catalina.LifecycleException;

import java.io.IOException;


/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class HttpProtocol implements Protocol {
    public void start(URL url) throws LifecycleException {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());
    }

    public String send(URL url, Invocation invocation) throws IOException {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(),invocation);
    }
}
