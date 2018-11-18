package net.wn.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.wn.entity.PositionP;
import net.wn.service.EmployeeServiceI;
import net.wn.service.EmployeeServiceImpl;
import net.wn.service.PositionServiceImpl;
import net.wn.service.PositonServiceI;
import net.wn.vo.EmployeeVo;
import net.wn.vo.PositionVo;
@WebServlet("/positionServlet")
public class PositionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	  
	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("查询成功");
		try {
			req.setCharacterEncoding("utf-8");
			// String callback=req.getParameter("callback");
			PositonServiceI positonServiceI= new PositionServiceImpl();
			List<PositionP> pos = new ArrayList<PositionP>();
			
			pos = positonServiceI.findAll();
			System.out.println(pos.toString());
			
			resp.setCharacterEncoding("utf-8");
			JSON json = new JSONObject();
			String positions = json.toJSONString(pos);

			resp.getWriter().write(positions);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void findPosition(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("findposition成功");
		try {
			req.setCharacterEncoding("utf-8");
			// String callback=req.getParameter("callback");
			PositonServiceI positonServiceI= new PositionServiceImpl();
			List<PositionVo> pos = new ArrayList<PositionVo>();
			pos = positonServiceI.findPosition();
			System.out.println(pos.toString());
			resp.setCharacterEncoding("utf-8");
			JSON json = new JSONObject();
			String positions = json.toJSONString(pos);
			resp.getWriter().write(positions);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

}
