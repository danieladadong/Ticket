package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import pojo.Order;
import pojo.Person;
import pojo.Seal;
import result.Result;
import util.DataBaseUtils;

public class OrderDaoImpl implements OrderDao {
	DataBaseUtils data = new DataBaseUtils();
	@Override
	public int buyTicket(Order order) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "INSERT INTO `order` (car_info_id, person_id, change_times, status) VALUES (?, ?, ?, ?)";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getCarInfoId());
			pstmt.setInt(2, order.getPersonId());
			pstmt.setInt(3, order.getChangeTimes());
			pstmt.setInt(4, order.getStatus());
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateOrder(int orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> getOrder(String userName) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from `order`,user where user.person_id = `order`.person_id and user.username = ?";
		List<Order> orderList = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setCarInfoId(rs.getInt("car_info_id"));
				order.setPersonId(rs.getInt("person_id"));
				order.setChangeTimes(rs.getInt("change_times"));
				order.setStatus(rs.getInt("status"));
				orderList.add(order);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public int updateOrder1(int personId, String carNum, String startTime, String reachTime) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update `order` set status = 2 where person_id=? and car_info_id = (select id from trips where car_num = ?" +
	            " and start_time = ? and reach_time = ?)";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, personId);
			pstmt.setString(2, carNum);
			pstmt.setString(3, startTime);
			pstmt.setString(4, reachTime);
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Order getAimOrder(int orderId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from `order` where id = ?";
		Order order = new Order();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				order.setId(rs.getInt("id"));
				order.setCarInfoId(rs.getInt("car_info_id"));
				order.setPersonId(rs.getInt("person_id"));
				order.setChangeTimes(rs.getInt("change_times"));
				order.setStatus(rs.getInt("status"));
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public Person getPersoninf(int personId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from person where id = ?";
		Person person = new Person();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, personId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				person.setTrueName(rs.getString("true_name"));
				person.setIdCardNum(rs.getString("id_card_num"));
				person.setPhoneNum(rs.getString("phone_num"));
				person.setAge(rs.getInt("age"));
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return person;
	}

	@Override
	public int changeOrder(int orderId, int tripsId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update `order` set car_info_id = ?,change_times = change_times +1,status = 1 where id = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tripsId);
			pstmt.setInt(2, orderId);
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Seal> getSeal() {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select `trips`.car_num as 'car_num',(count(car_info_id)-sum(`status`=2)) as 'count_trips',sum(`status`=2) as 're_trips',sum(change_times>0) as 'change_trips',ticket_price*sum(`status`=1) as 'seal' from `order`,`trips` where `order`.car_info_id= `trips`.id  GROUP BY car_info_id;";
		List<Seal> sealList = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Seal seal = new Seal();
				seal.setCar_num(rs.getString("car_num"));
				seal.setCount_seal_trips(rs.getInt("count_trips"));
				seal.setRe_trips(rs.getInt("re_trips"));
				seal.setChange_trips(rs.getInt("change_trips"));
				seal.setSeal(rs.getInt("seal"));
				sealList.add(seal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sealList;
	}

}
