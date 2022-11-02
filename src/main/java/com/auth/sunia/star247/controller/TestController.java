package com.auth.sunia.star247.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.auth.sunia.star247.auth.server.bean.auth.enums.VerTypeEnum;
import com.auth.sunia.star247.auth.server.bean.vertype.VerTypeInterface;
import com.auth.sunia.star247.converter.CarConverter;
import com.auth.sunia.star247.entity.CarEntity;
import com.auth.sunia.star247.entity.VO.CarEntityVO;
import com.auth.sunia.star247.service.ICacheService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TestController {

    /*
    -javaagent:/Users/star/Documents/theme/skywalking/skywalking-agent/skywalking-agent.jar -Dskywalking.agent.service_name=sharding-demo -Dskywalking.collector.backend_service=localhost:11800


    *
    */


    @Autowired
    Map<String, VerTypeInterface> verTypeInterfaceMap;


    @GetMapping("aaa")
    public String licenseCommitV2(@RequestParam(name = "aaa") String aaa) {
        log.error("=======================");
        //TODO 获取版本号
        verTypeInterfaceMap.get(VerTypeEnum.v2.getBeanName()).accept();

        System.out.println(aaa);

        return "success";

    }


    @CreateCache(name = "UserService:userCache:", expire = 10000, cacheType = CacheType.BOTH, localLimit = 50)
    private Cache<Long, Long> userCache2;

    @Autowired
    ICacheService cacheService;

    @GetMapping("a")
    public String getMessage(String id) {
        String s = cacheService.fingCache(id);
        return String.format("message %s is %s", id, s);
    }


    @GetMapping("b")
    public Long cache2test() {

        return userCache2.get(123L);

    }


    @GetMapping("c")
    public void cache2testc() {

        userCache2.put(123L, 789L);

    }

    @GetMapping("d")
    public void cache2testd() {

        userCache2.put(123L, 999L);

    }

//    @Autowired
//    CarConverter carConverter;

    @GetMapping("e")
    public CarEntityVO e() {

        final CarEntity car = new CarEntity();
        car.setId(1L);
        car.setName("name");
        car.setColor("yello");
//         CarEntityVO carEntityVO = carConverter.carToCarDto(car);
        CarEntityVO carEntityVO = CarConverter.instances.carToCarDto(car);

        return carEntityVO;

    }


}
