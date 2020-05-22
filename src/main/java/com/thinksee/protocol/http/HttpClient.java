package com.thinksee.protocol.http;

import com.thinksee.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class HttpClient {
    public String send(String hostname, Integer port, Invocation invocation) throws IOException {
        URL url = new URL("http", hostname, port, "/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

        OutputStream outputStream = httpURLConnection.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        oos.writeObject(invocation);
        oos.flush();
        oos.close();

        InputStream inputStream = httpURLConnection.getInputStream();
        return IOUtils.toString(inputStream);
    }
}
