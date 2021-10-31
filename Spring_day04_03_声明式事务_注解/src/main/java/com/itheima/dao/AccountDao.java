package com.itheima.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {

    void inMoney(@Param("name") String name, @Param("money") Double money);

    void outMoney(@Param("name") String name, @Param("money") Double money);
}
