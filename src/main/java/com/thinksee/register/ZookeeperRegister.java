package com.thinksee.register;

import com.alibaba.fastjson.JSONObject;
import com.thinksee.framework.URL;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class ZookeeperRegister implements RemoteReigister{
    static CuratorFramework client;
    static {
        client = CuratorFrameworkFactory
                .newClient("localhost:2181", new RetryNTimes(3,  1000));
        client.start();
    }

    private static Map<String, List<URL>> REGISTER = new HashMap<String, List<URL>>();

    public void regist(String interfaceName, URL url) throws Exception {
        String result = client
                .create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath(String.format("/dubbo/service/%s/%s", interfaceName, JSONObject.toJSONString(url)),  null);

        System.out.println(result);
    }

    public List<URL> get(String interfaceName) throws Exception {
        List<URL> urlList = new ArrayList<URL>();
        List<String> result = client
                .getChildren()
                .forPath(String.format("/dubbo/service/%s"));
        for(String urlstr: result) {
            urlList.add(JSONObject.parseObject(urlstr, URL.class));
        }
        REGISTER.put(interfaceName, urlList);
        return urlList;
    }
}
