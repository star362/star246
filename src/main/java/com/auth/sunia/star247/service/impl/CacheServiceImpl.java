package com.auth.sunia.star247.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import com.auth.sunia.star247.service.ICacheService;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/5/18 16:45
 * @describe: <br>
 */
public class CacheServiceImpl implements ICacheService {

    @CreateCache(expire = 100)
    private Cache<Long, String> userCache;

    @Override
    public String fingCache() {



        return null;
    }
}
