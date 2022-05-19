package com.auth.sunia.star247;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheGetResult;
import com.alicp.jetcache.anno.CachePenetrationProtect;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
class Star247ApplicationTests {


    @CreateCache(expire = 100)
    private Cache<Long, Long> userCache;

    //    创建一个两级（内存+远程）的缓存，内存中的元素个数限制在50个。
    @CreateCache(name = "UserService.userCache-", expire = 1000, cacheType = CacheType.BOTH, localLimit = 50)
    private Cache<Long, Long> userCache2;

    @Test
    void contextLoads() {
        Long user = userCache.get(123L);

        log.info("=======get==user======[{}]", user);

        userCache.put(123L, 999L);
        user = userCache.get(123L);
        log.info("=======put==user======[{}]", user);
//        userCache.remove(123L);
//        user = userCache.get(123L);
//        log.info("======remove===user======[{}]",user);
    }


    @Test
    void testcache2() {
        Long user = userCache2.get(123L);

        log.info("=======get==user======[{}]", user);
        userCache2.put(123L, 999L);
        user = userCache2.get(123L);
        log.info("=======put==user======[{}]", user);
    }



    @Test
    void testcache3(){
//        CacheGetResult<String> user2 = userCache2.GET(123L);
//        if (user2.isSuccess()) {
//            log.info("=======get==user2.getValue()======[{}]", user2.getValue());
//        }
    }

    public static void main(String[] args) {

    }

}
