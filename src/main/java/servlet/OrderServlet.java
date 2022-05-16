package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import impl.OrderDaoImpl;
import impl.PersonDaoImpl;
import impl.TripsDaoImpl;
import impl.UserDaoImpl;
import pojo.Order;
import pojo.OrderReturn;
import pojo.Person;
import pojo.Trips;
import pojo.User;
import result.Result;
import util.GetRequestJsonUtils;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if("getseal".equals(action)) {
			OrderDaoImpl orderdao = new OrderDaoImpl();
			String json = JSON.toJSONString(orderdao.getSeal());
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		Result result = new Result();
		if("getorder".equals(action)) {
			String username = request.getParameter("username");
			OrderDaoImpl orderdao = new OrderDaoImpl();
			TripsDaoImpl tripsdao = new TripsDaoImpl();
			List<Order> orderList = orderdao.getOrder(username);
			List<OrderReturn> orderReturnList  = new ArrayList<OrderReturn>();
	        Person person = new Person();
	        Trips trips = new Trips();
			if(orderList!=null) {
				for(Order i:orderList){
	                OrderReturn orderReturn = new OrderReturn();
	                person = orderdao.getPersoninf(i.getPersonId());
	                trips = tripsdao.gettrips(i.getCarInfoId());
	                orderReturn.setTrueName(person.getTrueName());
	                orderReturn.setIdCardNum(person.getIdCardNum());
	                orderReturn.setPhoneNum(person.getPhoneNum());
	                orderReturn.setId(trips.getId());
	                orderReturn.setOrderid(i.getId());
	                orderReturn.setCarNum(trips.getCarNum());
	                orderReturn.setDestinationLocation(trips.getDestinationLocation());
	                orderReturn.setOrginLocation(trips.getOrginLocation());
	                orderReturn.setTicketPrice(trips.getTicketPrice());
	                orderReturn.setTicketNum(trips.getTicketNum());
	                orderReturn.setStartTime(trips.getStartTime());
	                orderReturn.setReachTime(trips.getReachTime());
	                if (i.getStatus() == 1){
	                    orderReturn.setStatus("已支付");
	                }else if(i.getStatus()==2) {
	                    orderReturn.setStatus("已退票");
	                }else if(i.getStatus()==0) {
	                	orderReturn.setStatus("未支付");
	                }
//	                orderReturn.setStartTime(orderReturn.getStartTime());
//	                orderReturn.setStartTime(trips.getStartTime());
	                orderReturnList.add(orderReturn);
				}
			result.setStateCode(200);
            result.setMsg("查询成功！");
            result.setData(orderReturnList);
			
			}else {
				result.setStateCode(404);
	            result.setData(false);
	            result.setMsg("查询失败！订单不存在！");
			}
			String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}else if("buyticket".equals(action)) {
			String username = request.getParameter("username");
			String carNum = request.getParameter("carNum");
			String startTime = request.getParameter("startTime");
			TripsDaoImpl tripsdao = new TripsDaoImpl();
			Trips trips = tripsdao.getTripsInfoByCarNumAndStartTime(carNum, startTime);
			UserDaoImpl userdao = new UserDaoImpl();
			User user = userdao.getUserByUsername(username);
			PersonDaoImpl persondao = new PersonDaoImpl();
			Person person = persondao.getPersonInfo(user.getId());
			if (person == null){
	            result.setStateCode(400);
	            result.setMsg("购票前请完善用户个人信息");
	            result.setData(false);
	        }
			OrderDaoImpl orderdao = new OrderDaoImpl();
			Order order = new Order();
			order.setPersonId(user.getPersonId());
			order.setCarInfoId(trips.getId());
			order.setChangeTimes(0);
			order.setStatus(1);
			if(trips.getTicketNum()>=1) {
				orderdao.buyTicket(order);
				trips.setTicketNum(trips.getTicketNum()-1);
				trips.setCarNum(null);
				int i = tripsdao.updateTrips(trips);
				Map<String, Object> detailData = new HashMap<>();
				if(i==1) {
					result.setMsg("购票成功");
	                  result.setStateCode(200);
	                  detailData.put("personInfo",person);
	                  detailData.put("customer", user);
	                  detailData.put("changeTimes",3 - order.getChangeTimes());
	                  detailData.put("order", order);
	                  result.setData(detailData);
				}
			}else {
				result.setMsg(" 购买失败，车票已经卖光");
	            result.setStateCode(400);
	            result.setData(false);
			}
			String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}else if("changeorder".equals(action)) {
			int orderid = Integer.parseInt(request.getParameter("orderId"));
			int tripsid = Integer.parseInt(request.getParameter("tripsId"));
			OrderDaoImpl orderdao = new OrderDaoImpl();
			TripsDaoImpl tripsdao = new TripsDaoImpl();
			Order order = orderdao.getAimOrder(orderid);
			Trips trips = tripsdao.gettrips(tripsid);
			if(trips.getTicketNum()>0) {
				tripsdao.changeOldtrips(order.getCarInfoId());
				tripsdao.changeNewtrips(tripsid);
				int tmp = orderdao.changeOrder(orderid, tripsid);
				if(tmp>0) {
					result.setStateCode(200);
		            result.setMsg("改签成功!");
				}
			}else {
				result.setStateCode(404);
	            result.setMsg("改签失败!");
			}
			String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}
	}

}
