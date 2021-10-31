package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author sqh
 * @create 2021-05-03 21:22
 */
public interface AccountDao {

    //五个操作（这些配置原先是在resource中的）
    @Insert("INSERT INTO account (NAME,money) VALUES(#{name},#{money})")
    void save(Account account);

    @Delete("DELETE FROM account WHERE id = #{id}")
    void delete(Integer id);

    @Update("UPDATE account SET NAME = #{name},money = #{money} WHERE id = #{id}")
    void update(Account account);

    @Select("SELECT * FROM account")
    List<Account> findAll();

    @Select("SELECT * FROM account WHERE id = #{id}")
    Account findById(Integer id);
}
