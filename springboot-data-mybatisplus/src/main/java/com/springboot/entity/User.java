package com.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author swy
 * @description:
 * @date 2020/11/25 11:13
 */
@ToString
@Data
public class User {

    private String id;
    private String name;
}
