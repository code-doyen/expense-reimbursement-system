package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import com.revature.controller.LoginController;
import com.revature.model.Reimbursement;
import com.revature.model.Staff;
import com.revature.service.ReimbursementService;
import com.revature.service.StaffService;
public class RequestHelper {
	public static Object process(HttpServletRequest request){
		Staff s = (Staff) request.getSession().getAttribute("loggedStaff");
		System.out.println(request.getParameter("filter"));
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()){
		case "/Project1/listAllUsersRequests.ajax":  //requests a controller  done
			return ReimbursementService.getReimbursementService().listAllUsers();
		case "/Project1/resolvedRequestees.ajax":  //requests a controller 
			return ReimbursementService.getReimbursementService().listAllUserRequestees(new Reimbursement("RESOLVED"));
		case "/Project1/pendingRequestees.ajax":  //requests a controller
			return ReimbursementService.getReimbursementService().listAllUserRequestees(new Reimbursement("PENDING"));
		case "/Project1/usersRequests.ajax":  //requests a controller
			return ReimbursementService.getReimbursementService().listAllUsersRequests(new Reimbursement(request.getParameter("filter")));
		case "/Project1/pendingStaffRequests.ajax":  //requests a controller
			return ReimbursementService.getReimbursementService().listAllStaffRequests(new Reimbursement(s.getId(), "PENDING"));
		case "/Project1/resolvedStaffRequests.ajax":  //requests a controller
			return ReimbursementService.getReimbursementService().listAllStaffRequests(new Reimbursement(s.getId(), "RESOLVED"));
		case "/Project1/listAllUsers.ajax":  //requests a controller
			return StaffService.getStaffService().listAllUsers();
		case "/Project1/updateReimbursement.ajax":  //requests a controller															//('status', id)
			return ReimbursementService.getReimbursementService().updateReimbursementSecure(new Reimbursement("DENIED", 1));
		case "/Project1/listAllDetails.ajax":  //requests a controller
			return StaffService.getStaffService().listAllDetails(s); //('user')		
		case "/Project1/updateStaff.ajax":  //requests a controller
			return StaffService.getStaffService().updateStaffSecure(
					//('user', 'password', 'first_name', 'last_name', 'phone', 'email')
					new Staff(request.getSession().getAttribute("loggedStaff").toString(), request.getParameter("password"),
							request.getParameter("firstname"), request.getParameter("lastname"),
							request.getParameter("phone"), request.getParameter("email")));
			//return "profile.html";
		case "/Project1/registerReimbursement.ajax":  //requests a controller
			return ReimbursementService.getReimbursementService().registerReimbursementSecure(
					//(staff_id,  amount, description, image, 'type desc');
					new Reimbursement(s.getId(),  212, "java", null, "coffee"));
		case "/Project1/registerStaff.ajax":  //requests a controller
			return StaffService.getStaffService().registerStaffSecure(
					//("username", "password", , "elena", "vollmar", null || phone, "elena@bgsu.edu", "Manager")
					new Staff(request.getParameter("username"), request.getParameter("password"), 
							Integer.parseInt(request.getParameter("rank")), request.getParameter("firstname"),
							request.getParameter("lastname"), request.getParameter("phone"),
							request.getParameter("email"), request.getParameter("status")));
		default:
			System.out.println(request.getRequestURI());
			return LoginController.login(request);
			
			//return new AjaxMessage(FinalUtil.NOT_IMPLEMENTED_CODE, FinalUtil.NOT_IMPLEMENTED);
		}
	}
}
