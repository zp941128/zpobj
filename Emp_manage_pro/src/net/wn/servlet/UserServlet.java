package net.wn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.wn.entity.User;
import net.wn.service.UserServiceI;
import net.wn.service.UserServiceImpl;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		String methodName = req.getParameter("method");
		try {
	
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			
			method.setAccessible(true);
			
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("login³É¹¦");
		String account=req.getParameter("account");
		String password=req.getParameter("password");
		User user=new User();
		user.setAccount(account);
		user.setPassword(password);
		UserServiceI userServiceI=new UserServiceImpl();
		JSON  json=new JSONObject();
	    try {
			User temp=userServiceI.login(user);
			if(temp==null||temp.getAccount()==null)	
			{    
			   resp.getWriter().write("error");
			}
			else{
				resp.getWriter().write(json.toJSONString(temp));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}
     
}
