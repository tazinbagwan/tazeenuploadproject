package com.tka.OrganaizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.tka.OrganaizationSystem.entity.Country;
import com.tka.OrganaizationSystem.entity.Employee;

@Repository
public class MainDao {
	
	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		
		session.persist(c);
		tx.commit();
		msg="Country is added...";
		}catch(Exception e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}
     
	public String updateRecord(int id, Country c) {
    	Session session= null;
    	Transaction tx=null;
    	String msg= null;
    	
		try {
      session= factory.openSession();	
		tx =session.beginTransaction();
		
		Country country= session.get(Country.class, id);
		
		country.setCname(c.getCname());
		session.merge(country);
		tx.commit();
	
		
		msg="Record updated Sucessfully";
		}catch (Exception e) {
	
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return msg; 	
    }

public String deleteRecord(int id) {
	Session session= null;
	Transaction tx=null;
	String msg= null;
	
	try {
	 session= factory.openSession();	
	 tx=session.beginTransaction();
	
	Country country= session.get(Country.class,id);
	session.remove(country);

	tx.commit();
	msg="Record deleted Sucessfully";
	}catch (Exception e) {

	if(tx!=null) {
		tx.rollback();
	}
	e.printStackTrace();
}finally {
	if(session!=null) {
		session.close();
	}
}
return msg; 	
}

public List<Country> getAllRecord(){
	
	String hqlQuery="from Country";
	
	Session session= factory.openSession();	
	session.beginTransaction();
	
org.hibernate.query.Query<Country>  query= session.createQuery(hqlQuery,Country.class);
	List<Country> list= query.list();
	session.getTransaction().commit();
	session.close();
	
	return list;
}

public String addEmployee(Employee emp) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
	session=factory.openSession();
	tx=session.beginTransaction();
	
	session.persist(emp);
	tx.commit();
	msg="Employee is added...";
	}catch(Exception e) {
		
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return msg;
	
}
public String updateEmployee(Employee emp) {
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
		
		session=factory.openSession();
		tx=session.beginTransaction();
		Employee employee= 
		session.get(Employee.class, emp.getId());
		
		employee.setName(emp.getName());
		employee.setCountry(emp.getCountry());
		employee.setCreatedby(emp.getCreatedby());
		employee.setCreateddtm(emp.getCreateddtm());
		employee.setUpdatedby(emp.getUpdatedby());
		employee.setUpdateddtm(emp.getUpdateddtm());
		employee.setDepartment(emp.getDepartment());
		employee.setStatus(emp.getStatus());
		employee.setPhoneno(emp.getPhoneno());
		employee.setEmailid(emp.getEmailid());
		employee.setSalary(emp.getSalary());
		
		session.merge(employee);
		tx.commit();
		msg="Employee Updatated Successfully...";
		
	}catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
		
	}finally {
		
		if(session!=null) {
			session.close();
		}
		
	}
	
	
	
	return msg;
} 
   
public String deleteEmployee(int id) {
	
	
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
		
		session=factory.openSession();
		tx=session.beginTransaction();
		
		Employee emp= session.get(Employee.class, id);
		session.remove(emp);
		tx.commit();
		msg="Employee is Deleted...";
		
	}catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
		
	}finally {
		
		if(session!=null) {
			session.close();
		}
		
	}
	return msg;
}

public List<Employee> getAllEmployee() {
	Session session=null;
	Transaction tx=null;
	List<Employee> list=null;
	String hqlQuey="from Employee";		
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
		Query<Employee> query= 
		session.createQuery(hqlQuey,Employee.class);
		list= query.list();
		tx.commit();
	}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}	
	return list;
}

public Employee getParticularById(int id) {
	
	Session session=null;
	Transaction tx=null;
	Employee emp=null;
	try {
		session=factory.openSession();
		tx=session.beginTransaction();
	emp= session.get(Employee.class, id);
		tx.commit();
	}catch (Exception e) {
		if(tx!=null) {
			tx.rollback();
		}
		e.printStackTrace();
		
	}finally {
		if(session!=null) {
			session.close();
		}
	}	
	return emp;
}
















}
