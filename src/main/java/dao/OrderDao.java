package dao;

import pojo.Order;
import pojo.Person;
import pojo.Seal;
import result.Result;

import java.util.List;


public interface OrderDao {
    /**
     *插入订单信息
     * @param order
     * @return
     */
    public abstract int buyTicket(Order order);

    /**
     * 退票，把statu改为2
     * @param orderId
     * @return
     */
    public abstract int updateOrder(int orderId);

    /**
     * 获取个人的历史订单
     * @param userName
     * @return
     */
    public List<Order> getOrder(String  userName);


    public abstract int updateOrder1(int personId, String carNum, String startTime, String reachTime);

//    @Select("select * from `order` where person_id = #{personId}")
//    public List<Order> getOrder(Order order);

    /**
     * 查询目标订单
     * @param orderId
     * @return
    * */
    public Order getAimOrder(int orderId);

    /**
     * 查询订单所有人信息
     */
    public Person getPersoninf(int personId);

    /**
     * 改签订单信息变更
     * @return
     */
    public int changeOrder(int orderId, int tripsId);

    public List<Seal> getSeal();

}
