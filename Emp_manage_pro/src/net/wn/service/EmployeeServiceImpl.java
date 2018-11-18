package net.wn.service;

import java.util.List;

import net.wn.entity.Employee;
import net.wn.util.BaseDao;
import net.wn.vo.EmployeeVo;

public class EmployeeServiceImpl implements EmployeeServiceI{
	public void add(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		BaseDao<Employee> bd=new BaseDao<>();
		String sql="INSERT into employee(name,gender,age,phone,address,positionId,info) VALUES (?,?,?,?,?,?,?);";
		bd.insert(sql,employee.getName(),employee.getGender(),employee.getAge(),employee.getPhone(),employee.getAddress(),employee.getPositionId(),employee.getInfo());
	}

	@Override
	public void remove(int id) throws Exception {
		// TODO Auto-generated method stub
		BaseDao<EmployeeVo> bd=new BaseDao<>();
		String sql="delete from employee where id=?";
		bd.delete(sql, id);
	}

	@Override
	public void modify(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		BaseDao<Employee> bd=new BaseDao<>();
		int id=employee.getId();
		String sql="update employee set id=?,name=?,gender=?,age=?,phone=?,address=?,positionId=?,info=? where id=?";
		bd.updata(sql, employee.getId(),employee.getName(),employee.getGender(),employee.getAge(),employee.getPhone(),employee.getAddress(),employee.getPositionId(),employee.getInfo(),id);
	}

	@Override
	public List<EmployeeVo> findAll() throws Exception {
		// TODO Auto-generated method stub
		BaseDao<EmployeeVo> bd=new BaseDao<>();
		String sql="SELECT employee.id,employee.name,employee.gender,employee.age,employee.phone,employee.address,positionP.name as positionName FROM employee LEFT JOIN positionP on employee.positionId=positionP.id";
		List<EmployeeVo> EmploeeVos=bd.getAll(sql,EmployeeVo.class );
		return EmploeeVos;
	}

	public Employee findOneById(int id) throws Exception {
		BaseDao<Employee> bd=new BaseDao<>();
		String sql="select * from employee where id=?";
		Employee  findOneId= bd.getOne(sql, Employee.class, id);
		return  findOneId;
	}

}
