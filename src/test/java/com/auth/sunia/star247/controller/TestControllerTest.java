package com.auth.sunia.star247.controller;

import com.auth.sunia.star247.converter.CarConverter;
import com.auth.sunia.star247.entity.CarEntity;
import com.auth.sunia.star247.entity.VO.CarEntityVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 *
 * </p>
 *
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/11/2 16:10
 */
@SpringBootTest
@Slf4j
class TestControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Autowired
    CarConverter carConverter;

    @Test
    void e() {
        final CarEntity car = new CarEntity();
        car.setId(1L);
        car.setName("name");
        car.setColor("yello");
//         CarEntityVO carEntityVO = carConverter.carToCarDto(car);
        CarEntityVO carEntityVO = CarConverter.instances.carToCarDto(car);
        log.info("{}", carEntityVO);
    }


    @Test
    void e2() {
        final CarEntity car = new CarEntity();
        car.setId(1L);
        car.setName("name");
        car.setColor("yello");
         CarEntityVO carEntityVO = carConverter.carToCarDto(car);
//        CarEntityVO carEntityVO = CarConverter.instances.carToCarDto(car);
        log.info("{}", carEntityVO);
    }
}