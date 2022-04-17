package com.auth.sunia.star247.auth.server.bean.auth.brand;

import com.auth.sunia.star247.auth.server.bean.auth.verauth.AbstractAuthIntV2;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/3/31 19:11
 * @describe: <br>
 */
@Component
public class AuthBrandV2 extends AbstractAuthIntV2 implements AuthBrand {
    @Override
    public void apple() {
        System.out.println("AuthBrandV2:::apple");
    }
}
