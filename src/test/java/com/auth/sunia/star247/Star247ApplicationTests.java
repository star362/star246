package com.auth.sunia.star247;

import cn.hutool.core.util.ObjectUtil;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.auth.sunia.star247.auth.server.bean.auth.ausum.AuthSumV1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Star247ApplicationTests {


    @CreateCache(expire = 100)
    private Cache<Long, String> userCache;

//    创建一个两级（内存+远程）的缓存，内存中的元素个数限制在50个。
    @CreateCache(name = "UserService.userCache", expire = 1000, cacheType = CacheType.REMOTE, localLimit = 50)
    private Cache<Long, String> userCache2;

    @Test
    void contextLoads() {
        String user = userCache.get(123L);
        log.info("=======get==user======[{}]",user);
        userCache.put(123L, "cachetest");
        user = userCache.get(123L);
        log.info("=======put==user======[{}]",user);
//        userCache.remove(123L);
//        user = userCache.get(123L);
//        log.info("======remove===user======[{}]",user);
    }


    @Test
    void testcache2() {
        String user = userCache2.get(123L);
        log.info("=======get==user======[{}]",user);
        userCache2.put(123L, "cachetest");
        user = userCache2.get(123L);
        log.info("=======put==user======[{}]",user);
    }













    public static void main(String[] args) {

    }

}
