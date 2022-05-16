package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import pojo.User;
import result.Result;
import util.DataBaseUtils;

public class UserDaoImpl implements UserDao {
	DataBaseUtils data = new DataBaseUtils();

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from user where username=?";
		User user = new User();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPersonId(rs.getInt("person_id"));
			}
		rs.close();
		pstmt.close();
		data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int insertUserRegisterInfo(User user) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "insert into user (username, password, person_id) values(?,?,?)";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getPersonId());
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
	public int updateUserRegisterInfo(User user) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
