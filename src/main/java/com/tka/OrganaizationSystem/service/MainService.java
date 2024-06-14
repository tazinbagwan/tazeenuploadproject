package com.tka.OrganaizationSystem.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tka.OrganaizationSystem.dao.MainDao;
import com.tka.OrganaizationSystem.entity.Country;
import com.tka.OrganaizationSystem.entity.Employee;

@Service
public class MainService {
	
	@Autowired
	MainDao dao;

	
	public String addCountry(Country c) {
		
		String msg= dao.addCountry(c);
		if(Objects.isNull(msg)) {
			msg="Country is added....";
		}
		return msg;
	}

public String updateRecord(int id,Country c) {
		
		String msg=dao.updateRecord(id,c);
		if(Objects.isNull(msg)) {
			msg="Country is not updated...";
		}
		return msg;
		
	}

    public String deleteCountry(int id) {
	// TODO Auto-generated method stub
	String msg=dao.deleteRecord(id);
	if(Objects.isNull(msg)) {
		msg="Country is not deleted..";
	}
	return msg;
}

   public List<Country> getAllRecord() {
	   List<Country> list=dao.getAllRecord();
		return list;
}

public String addEmployee(Employee emp) {
	String msg= dao.addEmployee(emp);
	if(Objects.isNull(msg)) {
		msg="Employee is added....";
	}
	return msg;
} 
public String updateEmployee(Employee emp) {
	
	String msg=dao.updateEmployee(emp);
	if(Objects.isNull(msg)) {
		msg="Record is not be Updatated";
	}
	
	return msg;
    }
     
public String deleteEmployee(int id) {
	
	String msg=dao.deleteEmployee(id);
	if(Objects.isNull(msg)) {
		msg="Record is not Deleted..";
	}		
	return msg;
}

public List<Employee> getAllEmployee() {
	
	List<Employee> list=
			dao.getAllEmployee();
	
	if(Objects.isNull(list)) {
		list=null;
	}		
	return list;
}
public Employee getParticularById(int id) {
	
	Employee emp= dao.getParticularById(id);
	if(Objects.isNull(emp)) {
		emp=null;
	}
	
	return emp;
}
}

