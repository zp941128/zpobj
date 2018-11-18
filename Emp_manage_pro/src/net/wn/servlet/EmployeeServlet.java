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

import net.wn.entity.Employee;
import net.wn.service.EmployeeServiceI;
import net.wn.service.EmployeeServiceImpl;
import net.wn.vo.EmployeeVo;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String methodName = req.getParameter("method");
		System.out.println(methodName);
		try {

			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);

			method.setAccessible(true);

			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void findOneById(HttpServletRequest req, HttpServletResponse resp) {
		   System.out.println("查询id");
			try {
				req.setCharacterEncoding("utf-8");
				// String callback=req.getParameter("callback");
				String id = req.getParameter("id");
				int id1 = Integer.parseInt(id);
				System.out.println(id1);
				Employee Emp =new Employee();
				EmployeeServiceI EmployeeServiceI = new EmployeeServiceImpl();
				Emp=EmployeeServiceI.findOneById(id1);
				resp.setCharacterEncoding("utf-8");
				JSON json = new JSONObject();
				String students = json.toJSONString(Emp);
				resp.getWriter().write(students);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public void modify(HttpServletRequest req, HttpServletResponse resp) {
		// 增加
		System.out.println("modify页面");
		EmployeeServiceI employeeServiceI = new EmployeeServiceImpl();
		try {
			req.setCharacterEncoding("utf-8");
			String id=req.getParameter("id");
			int  id1=Integer.parseInt(id);
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			int age1 = Integer.parseInt(age);
			String gender = req.getParameter("gender");
			int gender1 = Integer.parseInt(gender);
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String positionId = req.getParameter("positionId");
			int positionId1 = Integer.parseInt(positionId);
			String info = req.getParameter("info");
			Employee stu = new Employee(id1,name, age1, gender1, phone, address, positionId1, info);
			employeeServiceI.modify(stu);
			
			req.getRequestDispatcher("empInfo.html").forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void findAll(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("查询成功");
		try {
			req.setCharacterEncoding("utf-8");
			// String callback=req.getParameter("callback");
			EmployeeServiceI EmployeeServiceI = new EmployeeServiceImpl();
			List<EmployeeVo> Emp = new ArrayList<EmployeeVo>();
			try {
				Emp = EmployeeServiceI.findAll();
				System.out.println(Emp.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.setCharacterEncoding("utf-8");
			JSON json = new JSONObject();
			String students = json.toJSONString(Emp);

			resp.getWriter().write(students);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void remove(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 删除
		EmployeeServiceI employeeServiceI = new EmployeeServiceImpl();
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		employeeServiceI.remove(id1);
		req.getRequestDispatcher("empInfo.html").forward(req, resp);
		System.out.println(id);
	}

	public void add(HttpServletRequest req, HttpServletResponse resp) {
		// 增加
		System.out.println("add页面");
		
		try {
			req.setCharacterEncoding("utf-8");
			EmployeeServiceI employeeServiceI = new EmployeeServiceImpl();
			String name = req.getParameter("name");
			String age = req.getParameter("age");
			int age1 = Integer.parseInt(age);
			String gender = req.getParameter("gender");
			int gender1 = Integer.parseInt(gender);
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			 System.out.println(address);
			String positionId = req.getParameter("positionId");
			int positionId1 = Integer.parseInt(positionId);
			String info = req.getParameter("info");
			Employee stu = new Employee(1, name, age1, gender1, phone, address, positionId1, info);
		    employeeServiceI.add(stu);
			
			
			req.getRequestDispatcher("empInfo.html").forward(req, resp);
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
