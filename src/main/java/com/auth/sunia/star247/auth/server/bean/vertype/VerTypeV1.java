package com.auth.sunia.star247.auth.server.bean.vertype;

import com.auth.sunia.star247.auth.server.bean.auth.enums.V1Enum;
import com.auth.sunia.star247.auth.server.bean.auth.verauth.AbstractAuthIntV1;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/3/31 18:58
 * @describe: v1 版本 <br>
 * @see V1Enum
 */
@Component
public class VerTypeV1 implements VerTypeInterface {


    @Autowired
    Map<String, AbstractAuthIntV1> v1Map;


    @Trace(operationName = "accept()")//operationName 名称,不写则用默
    @Override
    public void accept() {

        //TODO 1 解密
        //TODO 2 获取授权类型bean

        System.out.println("VerTypeV1:::accept");
        v1Map.get(V1Enum.AuthSum.getBeanName()).apple();
    }
}
