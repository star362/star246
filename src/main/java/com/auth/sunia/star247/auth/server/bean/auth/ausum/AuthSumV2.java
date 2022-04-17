package com.auth.sunia.star247.auth.server.bean.auth.ausum;

import com.auth.sunia.star247.auth.server.bean.auth.verauth.AbstractAuthIntV2;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/3/31 19:10
 * @describe: <br>
 */
@Component
public class AuthSumV2 extends AbstractAuthIntV2 implements AuthSum  {
    @Override
    public void apple() {
        System.out.println("AuthSumV2:::apple");
    }
}
