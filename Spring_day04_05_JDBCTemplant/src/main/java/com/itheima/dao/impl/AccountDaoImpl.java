package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//dao注册为bean
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    //注入模板对象（来自于JDBCConfig中注入的第三方bean模板对象）
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Account account) {
        String sql = "insert into account(name,money) values(?,?)";
        //模板的使用，只要传参数和sql语句即可
        jdbcTemplate.update(sql,account.getName(),account.getMoney());
    }

    public void delete(Integer id) {
        String sql = "delete from account where id = ?";
        jdbcTemplate.update(sql,id);
    }

    public void update(Account account) {
        String sql = "update account set name = ? , money = ? where id = ?";
        jdbcTemplate.update(sql, account.getName(),account.getMoney(),account.getId());
    }

    public String findNameById(Integer id) {
        String sql = "select name from account where id = ?";
        //单字段查询可以使用专用的查询方法，必须制定查询出的数据类型，例如name为String类型
        return jdbcTemplate.queryForObject(sql,String.class,id );//需要三个参数
    }

    public Account findById(Integer id) {
        String sql = "select * from account where id = ?";
        //支持自定义行映射解析器
        /*
        JdbcTemplate使用的接口，用于按行映射ResultSet的行。
        此接口的实现执行将每一行映射到结果对象的实际工作，但无需担心异常处理
         */
        RowMapper<Account> rm = new RowMapper<Account>() {//匿名实现类
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                //这个方法mapRow（传入两个参数：rs、rowNum）
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setMoney(rs.getDouble("money"));
                return account;//做一个对象的封装映射
            }
        };
        return jdbcTemplate.queryForObject(sql,rm,id);
    }

    public List<Account> findAll() {
        String sql = "select * from account";
        //使用spring自带的行映射解析器，要求必须是标准封装
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Account>(Account.class));//其中一个参数是对应属性的映射器
    }

    public List<Account> findAll(int pageNum, int preNum) {
        String sql = "select * from account limit ?,?";
        //分页数据通过查询参数赋值
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Account>(Account.class), (pageNum-1)*preNum,preNum);
    }

    public Long getCount() {
        String sql = "select count(id) from account ";
        //单字段查询可以使用专用的查询方法，必须制定查询出的数据类型，例如数据总量为Long类型
        return jdbcTemplate.queryForObject(sql,Long.class);
    }
}
