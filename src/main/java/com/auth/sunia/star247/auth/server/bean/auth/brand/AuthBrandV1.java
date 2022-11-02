package com.auth.sunia.star247.auth.server.bean.auth.brand;

import com.auth.sunia.star247.auth.server.bean.auth.verauth.AbstractAuthIntV1;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/3/31 19:10
 * @describe: <br>
 */
@Component
public class AuthBrandV1 extends AbstractAuthIntV1 implements AuthBrand {

    @Trace(operationName = "apple()")//operationName 名称,不写则用默
    @Override
    public void apple() {
        System.out.println("AuthBrandV1:::apple");
    }
}
