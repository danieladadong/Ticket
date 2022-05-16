package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import impl.PersonDaoImpl;
import impl.UserDaoImpl;
import pojo.Person;
import pojo.User;
import result.Result;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		if("getpersoninfo".equals(action)) {
			String username = request.getParameter("username");
			PersonDaoImpl persondao = new PersonDaoImpl();
			Person person = persondao.getPersonInfo1(username);
			if (person == null) {
	            result.setStateCode(400);
	            result.setMsg("未填写个人信息，请完善个人信息");
	            result.setData(null);
	        } else {
	            result.setStateCode(200);
//	            result.setStateCode();
	            result.setMsg("查询成功，已填写个人信息");
	            result.setData(person);
	        }
			String json = JSON.toJSONString(result);
            PrintWriter out = response.getWriter();
            out.println(json);
			out.flush();
			out.close();
		}
	}

}
