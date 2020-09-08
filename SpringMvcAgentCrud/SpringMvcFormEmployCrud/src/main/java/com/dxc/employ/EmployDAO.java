package com.dxc.employ;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployDAO {
	
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	
	public int insert(Employ employ) {
		String cmd = "Insert into Employ values(?,?,?,?,?)";
		return template.update(cmd, new Object[] {employ.getEmpno(),
					employ.getName(),
					employ.getDept(),
					employ.getDesig(),
					employ.getBasic()});
	}
	
	public int delete(int empno) {
		String sql = "DELETE FROM EMPLOY WHERE Empno=?";
		return template.update(sql, new Object[] {empno});
	}

	public int update(Employ employ){  
	    String sql="update Employ set name=?, dept=?, desig=?, basic=? where empno= ?";
	    return template.update(sql, new Object[] {employ.getName(), employ.getDept(), employ.getDesig(), 
	    				employ.getBasic(), employ.getEmpno()});
	}  
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public Employ searchByEmpno(int empno){  
	    String sql="select * from Employ where empno=?";  
	    return template.queryForObject(sql, 
	    		new Object[]{empno},new BeanPropertyRowMapper<Employ>(Employ.class));  
	}  
	
	public List<Employ> getEmployees(){  
		 return template.query("select * from Employ",new RowMapper<Employ>(){  
		        public Employ mapRow(ResultSet rs, int row) throws SQLException {  
		            Employ e=new Employ();  
		            e.setEmpno(rs.getInt("empno"));
		            e.setName(rs.getString("name"));
		            e.setDept(rs.getString("dept"));
		            e.setDesig(rs.getString("desig"));
		            e.setBasic(rs.getInt("basic"));
		            return e;  
		        }  
		    });  
	}
	
}
