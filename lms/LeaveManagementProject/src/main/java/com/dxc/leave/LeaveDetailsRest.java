package com.dxc.leave;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/leave")
public class LeaveDetailsRest {
	
	@POST
	  @Path("/applyLeave/")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public String applyLeave(LeaveDetails leave) throws SQLException {
	    String s = new LeaveDAO().applyLeave(leave);
	    System.out.println(s);
	    return s;
	  }
	
	@GET
	@Path("/approve/{leaveId}/{empMgrId}/{status}/{mgrComment}")
	@Produces(MediaType.APPLICATION_JSON)
	public String approveDeny(@PathParam("leaveId") int leaveId, @PathParam("empMgrId") int empMgrId,@PathParam("status") String status,@PathParam("mgrComment") String mgrComment) throws SQLException {
		String dao = new LeaveDAO().approveDeny(leaveId,empMgrId,status,mgrComment);
		return dao;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetails[] showLeaves() throws SQLException {
		LeaveDetails[] list = new LeaveDAO().showLeaves();
		return list;
	}
	
	@GET
	@Path("/pendingLeaves/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetails[] pendingLeaves(@PathParam("empId") int empId) throws SQLException {
		LeaveDetails[] list = new LeaveDAO().pendingLeaves(empId);
		return list;   
	}
	
	@GET
	@Path("/leaveHistory/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetails[] showLeaveHistory(@PathParam("empId") int empId) throws SQLException {
		LeaveDetails[] list = new LeaveDAO().leaveHistory(empId);
		return list;
	}
	
	@GET
	@Path("/{leaveId}")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaveDetails showLeave(@PathParam("leaveId") int leaveId) throws SQLException {
		LeaveDetails result = new LeaveDAO().searchLeave(leaveId);
		return result;
	}
	
	
	
//	@GET
//	@Path("/showleave/{leaveId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public LeaveDetails searchLeave(@PathParam("leaveId") int leaveId) throws SQLException {
//		return new LeaveDAO().searchLeave(leaveId);
//	}

}
