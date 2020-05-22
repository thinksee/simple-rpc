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
public class URL implements Serializable {
    private String hostname;
    private Integer port;
}
