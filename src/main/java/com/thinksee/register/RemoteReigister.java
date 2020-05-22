package com.thinksee.register;

import com.thinksee.framework.URL;

import java.io.IOException;
import java.util.List;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public interface RemoteReigister {
    void regist(String interfaceName, URL url) throws Exception;
    List<URL> get(String interfaceName) throws IOException, ClassNotFoundException, Exception;
}
