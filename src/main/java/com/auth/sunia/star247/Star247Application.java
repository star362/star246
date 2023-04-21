package com.auth.sunia.star247;

import cn.hutool.extra.spring.EnableSpringUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@EnableMethodCache(basePackages = "com.auth.sunia.star247")
@EnableCreateCacheAnnotation
@SpringBootApplication
@Slf4j
@EnableSpringUtil
public class Star247Application implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(Star247Application.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Stream.of(SpringUtil.getApplicationContext().getBeanDefinitionNames()).forEach(a -> {
//            log.info("beanName:【{}】\n className:[{}]", a, SpringUtil.getBean(a).getClass().getName());
//        });


    }
}
