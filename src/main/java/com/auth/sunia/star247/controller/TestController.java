package com.auth.sunia.star247.controller;

import com.alicp.jetcache.anno.CreateCache;
import com.auth.sunia.star247.auth.server.bean.auth.enums.VerTypeEnum;
import com.auth.sunia.star247.auth.server.bean.vertype.VerTypeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/3/31 19:14
 * @describe: <br>
 */
@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    Map<String, VerTypeInterface> verTypeInterfaceMap;


    @GetMapping("aaa")
    public String licenseCommitV2(){
        log.info("=======================");
        //TODO 获取版本号
        verTypeInterfaceMap.get(VerTypeEnum.v1.getBeanName()).accept();

        int i=1/0;

        return "success";

    }
}
