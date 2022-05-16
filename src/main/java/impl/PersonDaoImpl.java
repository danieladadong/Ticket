package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.PersonDao;
import pojo.Person;
import pojo.Trips;
import result.Result;
import util.DataBaseUtils;

public class PersonDaoImpl implements PersonDao {
	DataBaseUtils data = new DataBaseUtils();
	@Override
	public Result getAlltrips(Trips trips) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUserInfo(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Result getTripsInfoByCarInfoIdAndId(Trips trips) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUserInfo(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Person getPersonInfo(int Id) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from person where id = ?";
		Person person = new Person();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				person.setId(rs.getInt("id"));
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
	public Person getPersonInfo1(String username) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from person where (select person_id from user where username = ?)";
		Person person = new Person();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				person.setId(rs.getInt("id"));
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

}
