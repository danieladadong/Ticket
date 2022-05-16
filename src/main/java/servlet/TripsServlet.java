package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import impl.OrderDaoImpl;
import impl.TripsDaoImpl;
import impl.UserDaoImpl;
import pojo.OrderReturn;
import pojo.Trips;
import result.Result;

/**
 * Servlet implementation class TripsServlet
 */
@WebServlet("/TripsServlet")
public class TripsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		if("ticketrefund".equals(action)) {
			UserDaoImpl userdao = new UserDaoImpl();
			OrderDaoImpl orderdao = new OrderDaoImpl();
			int personId = userdao.getUserByUsername(request.getParameter("username")).getPersonId();
			String carNum = request.getParameter("carNum");
			String startTime = request.getParameter("startTime");
			String reachTime = request.getParameter("reachTime");
			TripsDaoImpl tripsdao = new TripsDaoImpl();
	        //票数+1
	        int i = tripsdao.refundTrips(personId, carNum, startTime, reachTime);
	        //把订单状态改为退票
	        int j = orderdao.updateOrder1(personId, carNum, startTime, reachTime);
	        if (i > 0 && j > 0){
	            result.setData(true);
	            result.setMsg("退票成功");
	            result.setStateCode(200);
	        }else {
	            result.setData(false);
	            result.setMsg("退票失败");
	            result.setStateCode(400);
	        }
	        String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}else if("getOtherTrips".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String orginLocation = request.getParameter("orginLocation");
			String destinationLocation = request.getParameter("destinationLocation");
			TripsDaoImpl tripsdao = new TripsDaoImpl();
			List<OrderReturn> orderReturnList  = new ArrayList<OrderReturn>();
			List<Trips> tripsList = tripsdao.getOtherTrips(id, orginLocation, destinationLocation);
			if(tripsList!=null) {
				for(Trips trips:tripsList) {
					OrderReturn orderReturn = new OrderReturn();
					orderReturn.setId(trips.getId());
	                orderReturn.setCarNum(trips.getCarNum());
	                orderReturn.setDestinationLocation(trips.getDestinationLocation());
	                orderReturn.setOrginLocation(trips.getOrginLocation());
	                orderReturn.setTicketPrice(trips.getTicketPrice());
	                orderReturn.setTicketNum(trips.getTicketNum());
	                orderReturn.setStartTime(trips.getStartTime());
	                orderReturn.setReachTime(trips.getReachTime());
	                orderReturnList.add(orderReturn);
				}
				result.setStateCode(200);
	            result.setMsg("查询成功！");
	            result.setData(orderReturnList);
			}else {
				result.setStateCode(404);
	            result.setData(false);
	            result.setMsg("查询失败！列车不存在！");
			}
			String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
			
		}else if("getaimtrips".equals(action)) {
			String orginLocation = request.getParameter("orginLocation");
			String destinationLocation = request.getParameter("destinationLocation");
			String starttime = request.getParameter("starttime");
			Trips tmp = new Trips();
			tmp.setOrginLocation(orginLocation);
			tmp.setDestinationLocation(destinationLocation);
			tmp.setStartTime(starttime);
			TripsDaoImpl tripsdao = new TripsDaoImpl();
			List<OrderReturn> orderReturnList  = new ArrayList<OrderReturn>();
			List<Trips> tripsList = tripsdao.getAimtrips(tmp);
			if(tripsList!=null) {
				for(Trips trips:tripsList) {
					OrderReturn orderReturn = new OrderReturn();
					orderReturn.setId(trips.getId());
	                orderReturn.setCarNum(trips.getCarNum());
	                orderReturn.setDestinationLocation(trips.getDestinationLocation());
	                orderReturn.setOrginLocation(trips.getOrginLocation());
	                orderReturn.setTicketPrice(trips.getTicketPrice());
	                orderReturn.setTicketNum(trips.getTicketNum());
	                orderReturn.setStartTime(trips.getStartTime());
	                orderReturn.setReachTime(trips.getReachTime());
	                orderReturnList.add(orderReturn);
				}
				result.setStateCode(200);
	            result.setMsg("查询成功！");
	            result.setData(orderReturnList);
			}else {
				result.setStateCode(404);
	            result.setData(false);
	            result.setMsg("查询失败！列车不存在！");
			}
			String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}else if("getalltrips".equals(action)) {
			TripsDaoImpl tripsdao = new TripsDaoImpl();
			List<OrderReturn> orderReturnList  = new ArrayList<OrderReturn>();
			List<Trips> tripsList = tripsdao.getAlltrips();
			if(tripsList!=null) {
				for(Trips trips:tripsList) {
					OrderReturn orderReturn = new OrderReturn();
					orderReturn.setId(trips.getId());
	                orderReturn.setCarNum(trips.getCarNum());
	                orderReturn.setDestinationLocation(trips.getDestinationLocation());
	                orderReturn.setOrginLocation(trips.getOrginLocation());
	                orderReturn.setTicketPrice(trips.getTicketPrice());
	                orderReturn.setTicketNum(trips.getTicketNum());
	                orderReturn.setStartTime(trips.getStartTime());
	                orderReturn.setReachTime(trips.getReachTime());
	                orderReturnList.add(orderReturn);
				}
				result.setStateCode(200);
	            result.setMsg("查询成功！");
	            result.setData(orderReturnList);
			}else {
				result.setStateCode(404);
	            result.setData(false);
	            result.setMsg("查询失败！列车不存在！");
			}
			String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}else if("updatetrips".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String orginLocation = request.getParameter("orginLocation");
			String startTime = request.getParameter("startTime");
			String destinationLocation = request.getParameter("destinationLocation");
			String reachTime = request.getParameter("reachTime");
			String carNUm = request.getParameter("carNum");
			int ticketPrice = Integer.parseInt(request.getParameter("ticketPrice"));
			int ticketNum = Integer.parseInt(request.getParameter("ticketNum"));
			Trips trips = new Trips();
			trips.setId(id);
			trips.setOrginLocation(orginLocation);
			trips.setDestinationLocation(destinationLocation);
			trips.setStartTime(startTime);
			trips.setReachTime(reachTime);
			trips.setCarNum(carNUm);
			trips.setTicketPrice(ticketPrice);
			trips.setTicketNum(ticketNum);
			TripsDaoImpl tripsdao = new TripsDaoImpl();
			int tmp = tripsdao.updatetrips1(trips);
			if(tmp>0) {
				result.setStateCode(200);
	            result.setMsg("修改成功！");
	            result.setData(true);
			}else {
				result.setStateCode(404);
	            result.setData(false);
	            result.setMsg("修改失败！");
			}
			String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}
	}

}
