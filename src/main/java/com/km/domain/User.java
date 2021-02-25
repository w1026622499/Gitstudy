package com.km.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author Wh
 * @title
 * @description
 * @createTime 2021年02月05日 14:34:00
 * @modifier：Wh
 * @modification_time：2021-02-05 14:34
 */
@Data
@Alias("user")
public class User {

    private String empName;
    private Integer id;
    private String salary;

}
