package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	// Attributes:
	public static final String uname = "root";
	public static final String password = "root";
	
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String dburl = "jdbc:mysql://localhost/webportal";
	
	// Constructor:
	public EmployeeDaoImpl() {
		
	}
	
	// Method to get connection from SQL
	public static Connection getConnection() throws SQLException {
		
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			System.out.println("Unable to get forName()");
			e.printStackTrace();
		}
			
		try {
				conn= DriverManager.getConnection(dburl, uname, password);
				
			} catch (SQLException e) {
			System.out.println("Unable to get connection");
			e.printStackTrace();
			}
		return conn;
		
	}
	
	// Override methods from EmployeeDao interface
	@Override
	public int update(Employee emp) {
		int status = 0;
		
		int id = emp.getEmpId();
		String name = emp.getName();
		String password = emp.getPassword();
		String email = emp.getEmail();
		String country = emp.getCountry();	
		
		try {
			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("update usercrud "
					+ "set name = '" + name + "', password = '" + password + "', email = '" + email
					+ "', country = '" + country
					+ "' where id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			status = 1;

		} catch (Exception e) {
			System.out.println("Unable to update");
			e.printStackTrace();

		}

		return status;
	}

	@Override
	public int delete(int id) {
		int status = 0;
		try {
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from usercrud where id=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		status = 1;
		
		} catch (Exception e){
			System.out.println("Unable to delete record");
			e.printStackTrace();
			
		}
		return status;
	}

	@Override
	public int save(Employee emp) {
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into usercrud(id, name, password, email, country)"
					+ "values(?, ?, ?, ?, ?)");
			stmt.setInt(1, emp.getEmpId());
			stmt.setString(2, emp.getName());
			stmt.setString(3, emp.getPassword());
			stmt.setString(4, emp.getEmail());
			stmt.setString(5, emp.getCountry());
			stmt.executeUpdate();
			
			status = 1;
			
		} catch (Exception e) {
			System.out.println("Unable to save info");
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e=new Employee();  
        
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setEmpId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  



	@Override
	public List<Employee> getAllEmployees() {
			
		List<Employee> emplist = new ArrayList<Employee>();
		try {
			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from usercrud");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
						emplist.add(emp);
			}
			
		} catch (Exception e) {
			System.out.println("Unable to retrieve Employees from DB");
			e.printStackTrace();
		}
		
		
		return emplist;
	}

	
	
}
