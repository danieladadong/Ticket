package dao;

import pojo.Person;
import pojo.Trips;
import result.Result;

import java.util.List;

public interface PersonDao {


    /**
     * 查询全部车票信息
     * @param trips
     * @return
     * */
    public abstract Result getAlltrips(Trips trips);

    /**
     * 修改用户个人信息
     * @param person
     * @return
     */
    public abstract int updateUserInfo(Person person);

    /**
     * 通过id和车号查询车次信息
     * @param trips
     * @return
     */
    public abstract Result getTripsInfoByCarInfoIdAndId (Trips trips);


    /**
     * 添加用户个人信息
     * @param person
     * @return
     */
    public abstract int insertUserInfo(Person person);
    /**
     * 通过id获取个人信息
     * @return
     */

    public  Person getPersonInfo(int Id);

    /**
     * 通过username查询个人信息
     * @param username
     * @return
     */
//    @Select("select * from person where (select person_id from user where username = #{username}")
    public abstract Person getPersonInfo1(String username);


}
