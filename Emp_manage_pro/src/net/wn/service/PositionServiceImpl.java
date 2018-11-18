package net.wn.service;

import java.util.List;

import net.wn.entity.Empname;
import net.wn.entity.PositionP;
import net.wn.util.BaseDao;
import net.wn.vo.EmployeeVo;
import net.wn.vo.PositionVo;

public class PositionServiceImpl implements PositonServiceI{

	@Override
	public List<PositionP> findAll() throws Exception {
		BaseDao<PositionP> bd=new BaseDao<>();
		String sql="select * FROM positionp";
		List<PositionP> positions=bd.getAll(sql,PositionP.class );
		return positions;
	
	}

	@Override
	public List<PositionVo> findPosition() throws Exception {
		// TODO Auto-generated method stub
		BaseDao<PositionVo> bd=new BaseDao<>();
		String sql="SELECT id,name from positionp";
		List<PositionVo> positionList=bd.getAll(sql,PositionVo.class );
		for (PositionVo positionVo : positionList) {
			BaseDao<Empname> bd1=new BaseDao<>();
			String sql1="select name from employee where positionId="+positionVo.getId();
			List<Empname> employeeList= bd1.getAll(sql1,Empname.class );
			positionVo.setEmpname(employeeList);
			/*System.out.println(positionVo);*/
		}
	    System.out.println(positionList);
		return positionList;
		
	}
	public static void main(String[] args) {
		PositionServiceImpl a= new PositionServiceImpl();
		try {
			a.findPosition();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
