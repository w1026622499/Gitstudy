package com.km.mapper;

import com.km.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author Wh
 * @title
 * @description
 * @createTime 2021年02月07日 15:29:00
 * @modifier：Wh
 * @modification_time：2021-02-07 15:29
 */
public interface UserMapperClass {

    @Select("select * from emp where id = #{id}")
    User selectSpring(Integer id);

}
