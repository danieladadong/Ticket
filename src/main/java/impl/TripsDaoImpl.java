package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TripsDao;
import pojo.Trips;
import result.Result;
import util.DataBaseUtils;

public class TripsDaoImpl implements TripsDao {
	DataBaseUtils data = new DataBaseUtils();
	@Override
	public List<Trips> getAimtrips(Trips trips) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from trips where orgin_location=? and destination_location=?";
		List<Trips> tripsList = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, trips.getOrginLocation());
			pstmt.setString(2, trips.getDestinationLocation());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Trips tmp = new Trips();
				tmp.setId(rs.getInt("id"));
				tmp.setOrginLocation(rs.getString("orgin_location"));
				tmp.setDestinationLocation(rs.getString("destination_location"));
				tmp.setStartTime(rs.getString("start_time"));
				tmp.setReachTime(rs.getString("reach_time"));
				tmp.setCarNum(rs.getString("car_num"));
				tmp.setTicketPrice(rs.getInt("ticket_price"));
				tmp.setTicketNum(rs.getInt("ticket_num"));
				tripsList.add(tmp);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return tripsList;
	}

	@Override
	public List<Trips> getAlltrips() {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from trips";
		List<Trips> tripsList = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Trips tmp = new Trips();
				tmp.setId(rs.getInt("id"));
				tmp.setOrginLocation(rs.getString("orgin_location"));
				tmp.setDestinationLocation(rs.getString("destination_location"));
				tmp.setStartTime(rs.getString("start_time"));
				tmp.setReachTime(rs.getString("reach_time"));
				tmp.setCarNum(rs.getString("car_num"));
				tmp.setTicketPrice(rs.getInt("ticket_price"));
				tmp.setTicketNum(rs.getInt("ticket_num"));
				tripsList.add(tmp);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return tripsList;
	}

	@Override
	public Trips gettrips(int id) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from trips where id = ?";
		Trips trips = new Trips();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				trips.setId(rs.getInt("id"));
				trips.setOrginLocation(rs.getString("orgin_location"));
				trips.setDestinationLocation(rs.getString("destination_location"));
				trips.setStartTime(rs.getString("start_time"));
				trips.setReachTime(rs.getString("reach_time"));
				trips.setCarNum(rs.getString("car_num"));
				trips.setTicketPrice(rs.getInt("ticket_price"));
				trips.setTicketNum(rs.getInt("ticket_num"));
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trips;
	}

	@Override
	public int changeOldtrips(int oldId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update trips set ticket_num = ticket_num+1 where id = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, oldId);
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
	public int changeNewtrips(int newId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update trips set ticket_num = ticket_num-1 where id = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newId);
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
	public Trips getTripsInfoByCarInfoIdAndId(Trips trips) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTrips(Trips trips) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update trips set ticket_num = ? where id = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, trips.getTicketNum());
			pstmt.setInt(2, trips.getId());
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int updatetrips1(Trips trips) {
		Connection conn = data.getConnection();
		String sql = "update trips set orgin_location=?,destination_location=?,start_time=?,reach_time=?,car_num=?,ticket_price=?,ticket_num = ? where id = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, trips.getOrginLocation());
			pstmt.setString(2, trips.getDestinationLocation());
			pstmt.setString(3, trips.getStartTime());
			pstmt.setString(4,trips.getReachTime());
			pstmt.setString(5, trips.getCarNum());
			pstmt.setInt(6, trips.getTicketPrice());
			pstmt.setInt(7, trips.getTicketNum());
			pstmt.setInt(8, trips.getId());
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
	public int refundTrips(int personId, String carNum, String startTime, String reachTime) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update trips set ticket_num = ticket_num + 1 where  car_num = ? and start_time =? and reach_time = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carNum);
			pstmt.setString(2, startTime);
			pstmt.setString(3, reachTime);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Trips getTripsInfoByCarNumAndStartTime(String carNum, String startTime) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from trips where car_num = ? and start_time = ?";
		Trips trips = new Trips();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carNum);
			pstmt.setString(2, startTime);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				trips.setId(rs.getInt("id"));
				trips.setOrginLocation(rs.getString("orgin_location"));
				trips.setDestinationLocation(rs.getString("destination_location"));
				trips.setStartTime(rs.getString("start_time"));
				trips.setReachTime(rs.getString("reach_time"));
				trips.setCarNum(rs.getString("car_num"));
				trips.setTicketPrice(rs.getInt("ticket_price"));
				trips.setTicketNum(rs.getInt("ticket_num"));
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trips;
	}

	@Override
	public List<Trips> getOtherTrips(int id, String orginLocation, String destinationLocation) {
		Connection conn = data.getConnection();
		String sql = "select * from trips where orgin_location=? and destination_location=? and id <> ?";
		List<Trips> tripsList = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orginLocation);
			pstmt.setString(2, destinationLocation);
			pstmt.setInt(3, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Trips trips = new Trips();
				trips.setId(rs.getInt("id"));
				trips.setOrginLocation(rs.getString("orgin_location"));
				trips.setDestinationLocation(rs.getString("destination_location"));
				trips.setStartTime(rs.getString("start_time"));
				trips.setReachTime(rs.getString("reach_time"));
				trips.setCarNum(rs.getString("car_num"));
				trips.setTicketPrice(rs.getInt("ticket_price"));
				trips.setTicketNum(rs.getInt("ticket_num"));
				tripsList.add(trips);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return tripsList;
	}

}
