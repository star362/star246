package com.auth.sunia.star247.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.*;
import com.auth.sunia.star247.auth.server.bean.auth.enums.VerTypeEnum;
import com.auth.sunia.star247.auth.server.bean.vertype.VerTypeInterface;
import com.auth.sunia.star247.service.ICacheService;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        verTypeInterfaceMap.get(VerTypeEnum.v2.getBeanName()).accept();

        System.out.println(aaa);

        return "success";

    }



    @CreateCache(name = "UserService.userCache-", expire = 10000, cacheType = CacheType.BOTH, localLimit = 50)
    private Cache<Long, Long> userCache2;

    @Autowired
    ICacheService cacheService;

    @GetMapping("a")
    public String getMessage(String id) {
        String s = cacheService.fingCache(id);
        return String.format("message %s is %s", id, s);
    }


    @GetMapping("b")
    public Long cache2test(){

        return userCache2.get(123L);

    }


    @GetMapping("c")
    public void cache2testc(){

         userCache2.put(123L,789L);

    }

    @GetMapping("d")
    public void cache2testd(){

        userCache2.put(123L,999L);

    }
}
