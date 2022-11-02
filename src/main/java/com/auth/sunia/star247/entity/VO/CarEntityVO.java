package com.auth.sunia.star247.entity.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/11/2 15:50
 */
@Data
public class CarEntityVO implements Serializable {
    private static final long serialVersionUID = -1034107737183353940L;
    private Long id;
    private Long id2;
    private String name;
    private String color;
}
