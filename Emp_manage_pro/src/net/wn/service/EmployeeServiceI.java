package net.wn.service;

import java.util.List;

import net.wn.entity.Employee;
import net.wn.vo.EmployeeVo;

public interface EmployeeServiceI {
   void add(Employee employee) throws Exception;
   void remove(int id) throws Exception ;
   void modify(Employee employee) throws Exception;
   List<EmployeeVo> findAll() throws Exception;
   Employee findOneById(int id) throws Exception;
}
