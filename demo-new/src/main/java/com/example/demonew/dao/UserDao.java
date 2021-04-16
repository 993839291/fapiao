package com.example.demonew.dao;

import com.example.demonew.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("SELECT * from test ORDER BY d1 ASC;")
    List<User> getUserList();

    @Insert(" INSERT INTO `test` (`d1`,`type`) VALUES (#{id},#{type}); ")
    Integer insert(@Param("id") Integer id,@Param("type") Integer type);

    @Insert(" DELETE FROM `test`; ")
    Integer delete();


    @Insert(" INSERT INTO `test2` (`index`, `sub`, `add`) VALUES (#{index}, #{sub}, #{add}); ")
    Integer insert2(@Param("index") Integer id,@Param("sub") Integer sub,@Param("add") Integer add);


    @Insert(" DELETE FROM `test2`; ")
    Integer delete2();


    @Select("SELECT d1 from test ORDER BY type ASC LIMIT 0,5;")
    List<Integer> getIntegerUserList();
}
