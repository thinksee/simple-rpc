package com.thinksee.framework;

import java.util.List;
import java.util.Random;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class BalanceRamdom implements BalanceStrategy{
    public URL getURL(List<URL> list) {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}
