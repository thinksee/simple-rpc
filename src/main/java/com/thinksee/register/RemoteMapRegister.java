package com.thinksee.register;

import com.thinksee.framework.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 * 服务注册，注册到文件中
 **/
public class RemoteMapRegister implements RemoteReigister{
    private static Map<String, List<URL>> REGISTER = new HashMap<String, List<URL>>();

    public void regist(String interfaceName, URL url) {
        List<URL> list = REGISTER.get(interfaceName);
        if (null == list) {
            list = new ArrayList<URL>();
        }
        list.add(url);
        REGISTER.put(interfaceName, list);
        saveFile();
    }

    public List<URL> get(String interfaceName) throws IOException, ClassNotFoundException {
        REGISTER = getFile();
        List<URL> list = REGISTER.get(interfaceName);
        return list;
    }

    private static Map<String, List<URL>> getFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("temp.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Map<String, List<URL>>)objectInputStream.readObject();
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
