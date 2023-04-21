package com.auth.sunia.star247.auth.server.bean.auth.enums;

import com.auth.sunia.star247.auth.server.bean.auth.ausum.AuthSumV1;
import com.auth.sunia.star247.auth.server.bean.auth.brand.AuthBrandV1;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/4/1 15:00
 * @describe: v1 版本 授权枚举<br>
 */
public enum V1Enum {
    /**
     * 数量授权
     */
    AuthSum("authSumV1", AuthSumV1.class),
    /**
     * 品牌授权
     */
    AuthBrand("authBrandV1", AuthBrandV1.class);

    private String beanName;
    private Class beanClazz;

    V1Enum(String beanName, Class beanClazz) {
        this.beanName = beanName;
        this.beanClazz = beanClazz;
    }

    public String getBeanName() {
        return beanName;
    }

    public Class getBeanClazz() {
        return beanClazz;
    }
}
