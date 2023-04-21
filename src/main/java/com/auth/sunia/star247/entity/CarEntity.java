package com.auth.sunia.star247.entity;

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
public class CarEntity implements Serializable {


    private static final long serialVersionUID = 7481051052999109007L;


    private Long id;
    private String name;
    private String color;
}
