package com.thinksee.framework;

import java.util.List;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/
public class StrategyContext {
    private BalanceStrategy strategy;

    public StrategyContext(BalanceStrategy strategy){
        this.strategy = strategy;
    }

    public URL executeStrategy(List<URL> list){
        return strategy.getURL(list);
    }
}
