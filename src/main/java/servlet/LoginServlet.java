package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import impl.UserDaoImpl;
import pojo.User;
import util.GetRequestJsonUtils;
import result.Result;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		String action = request.getParameter("action");
		Result result = new Result();
		UserDaoImpl userdao = new UserDaoImpl();
		if("login".equals(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = userdao.getUserByUsername(username);
			if (user == null){
	            result.setData(null);
	            result.setMsg("用户名不存在！");
	            result.setStateCode(404);
	            String rjson = JSON.toJSONString(result);
	            PrintWriter out = response.getWriter();
	            out.println(rjson);
				out.flush();
				out.close();
	        }
	        if (!user.getPassword().equals(password)){
	            result.setMsg("账户或密码错误！");
	            result.setStateCode(404);
	            String rjson = JSON.toJSONString(result);
	            PrintWriter out = response.getWriter();
	            out.println(rjson);
				out.flush();
				out.close();
	         
	        }
	        result.setStateCode(200);
	        result.setMsg("登录成功！");
	        result.setData(user);
		}else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setPersonId((int)Math.random()*10+1);
			int tmp = userdao.insertUserRegisterInfo(user);
			if(tmp>0) {
				result.setMsg("注册成功!");
				result.setStateCode(200);
				result.setData(true);
			}else {
				result.setMsg("注册失败!");
				result.setStateCode(404);
				result.setData(false);
			}
		}
        String json = JSON.toJSONString(result);
        PrintWriter out = response.getWriter();
        out.println(json);
		out.flush();
		out.close();
	}

}
