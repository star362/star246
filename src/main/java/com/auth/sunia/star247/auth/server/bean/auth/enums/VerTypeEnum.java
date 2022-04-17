package com.auth.sunia.star247.auth.server.bean.auth.enums;

import com.auth.sunia.star247.auth.server.bean.vertype.VerTypeInterface;
import com.auth.sunia.star247.auth.server.bean.vertype.VerTypeV1;
import com.auth.sunia.star247.auth.server.bean.vertype.VerTypeV2;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/4/1 14:48
 * @describe: 版本号枚举<br>
 */
public enum VerTypeEnum {
    /**
     * V1 版本
     */
    v1("v1","verTypeV1", VerTypeV1.class),
    /**
     * v2 版本
     */
    v2("v2","verTypeV2", VerTypeV2.class)

    ;


    private String verNum;
    private String beanName;
    private Class beanClazz;

    VerTypeEnum(String verNum, String beanName, Class beanClazz) {
        this.verNum = verNum;
        this.beanName = beanName;
        this.beanClazz = beanClazz;
    }

    public String getVerNum() {
        return verNum;
    }

    public String getBeanName() {
        return beanName;
    }

    public Class getBeanClazz() {
        return beanClazz;
    }
}
