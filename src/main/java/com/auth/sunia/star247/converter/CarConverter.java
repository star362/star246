package com.auth.sunia.star247.converter;

import com.auth.sunia.star247.entity.CarEntity;
import com.auth.sunia.star247.entity.VO.CarEntityVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 *
 * </p>
 *
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/11/2 15:49
 */
@Mapper(componentModel = "spring")
public interface CarConverter {
    /**
     * 获取该类自动生成的实现类的实例
     * 接口中的属性都是 public static final 的 方法都是public abstract的
     */
    CarConverter instances = Mappers.getMapper(CarConverter.class);


    @Mappings({
            @Mapping(source = "id", target = "id2"),
            // 使用ignore
            @Mapping(target = "id", ignore = true)
    })

    CarEntityVO carToCarDto(CarEntity car);
}
