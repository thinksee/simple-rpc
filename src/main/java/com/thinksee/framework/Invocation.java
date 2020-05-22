package com.thinksee.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 * 此方法一定要实现序列化
 **/

@Data
@AllArgsConstructor
@ToString
public class Invocation implements Serializable {
    // 接口名字
    private String interfaceName;
    // 方法名字
    private String methodName;
    // 参数列表
    private Object[] params;
    // 参数类型列表
    private Class[] paramType;
}
