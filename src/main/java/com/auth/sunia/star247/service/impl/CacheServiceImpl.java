package com.auth.sunia.star247.service.impl;


import cn.hutool.core.util.RandomUtil;
import com.alicp.jetcache.anno.CachePenetrationProtect;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.auth.sunia.star247.service.ICacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/5/18 16:45
 * @describe: <br>
 */
@Slf4j
@Service
public class CacheServiceImpl implements ICacheService {


    @Cached(name = "CacheServiceImpl:message", key = "#id", expire = 20000, cacheType = CacheType.BOTH, localLimit = 50)
    @CacheRefresh(refresh = 10, stopRefreshAfterLastAccess = 1800)
//    @CachePenetrationProtect //并发保护
    @Override
    public String fingCache(String id) {

        log.info("=================id[{}]", id);

        return String.valueOf(RandomUtil.randomInt(10, 100));
    }
}
