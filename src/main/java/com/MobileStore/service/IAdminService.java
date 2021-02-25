package com.MobileStore.service;

import java.util.List;

import com.MobileStore.entity.Admin;
import com.MobileStore.entity.Mobile;

/**
 * Declares methods used to obtain and modify Admin and Mobile information.
 * @author Akash Karn
 */
public interface IAdminService {
	
	Admin adminLogin(String username, String password);

	List<Mobile> getMobiles();
	
	Mobile addMobile(Mobile mobile);
	
	Mobile editMobile(Mobile mobile);
	
	Mobile deleteMobile(Mobile mobile);
	
}
