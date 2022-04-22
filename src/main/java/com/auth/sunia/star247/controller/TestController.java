package com.auth.sunia.star247.controller;

import com.auth.sunia.star247.auth.server.bean.auth.enums.VerTypeEnum;
import com.auth.sunia.star247.auth.server.bean.vertype.VerTypeInterface;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /*
    -javaagent:/Users/star/Documents/theme/skywalking/skywalking-agent/skywalking-agent.jar -Dskywalking.agent.service_name=sharding-demo -Dskywalking.collector.backend_service=localhost:11800


    *
    */

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    Map<String, VerTypeInterface> verTypeInterfaceMap;


    @GetMapping("aaa")

    public String licenseCommitV2(@RequestParam(name = "aaa")String aaa){
        log.error("=======================");
        //TODO 获取版本号
        verTypeInterfaceMap.get(VerTypeEnum.v1.getBeanName()).accept();

        System.out.println(aaa);

        return "success";

    }
}
