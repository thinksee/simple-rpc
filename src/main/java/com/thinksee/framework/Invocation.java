package com.thinksee.framework;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by thinksee on 2020/5/22 0022.
 *
 * @author 1563896950@qq.com
 * @github https://www.github.com/thinksee
 **/

@Data
@AllArgsConstructor
public class Invocation implements Serializable {
    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class[] paramType;
}
