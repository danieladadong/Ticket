package dao;

import pojo.User;
import result.Result;


/**
 * User表持久类
 * @author wangchang
 * @version 0.1
 */
public interface UserDao {

    /**
     * 通过username查询User信息
     * @param username
     * @return
     */
    public abstract User getUserByUsername(String username);

    /**
     * 注册用户信息
     * @param user
     * @return
     */
    public abstract int insertUserRegisterInfo(User user);

    /**
     * 更新用户账户信息
     * @param user
     * @return
     */
    public abstract int updateUserRegisterInfo(User user);








}
