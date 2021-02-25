package com.MobileStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MobileStore.dao.IAdminDAO;
import com.MobileStore.dao.IMobileDAO;
import com.MobileStore.entity.Admin;
import com.MobileStore.entity.Mobile;
import com.MobileStore.exception.AlreadyExistsException;
import com.MobileStore.exception.InvalidArgumentException;
import com.MobileStore.exception.InvalidCredentialsException;
import com.MobileStore.exception.MobileNotFoundException;

/**
 * This implementation of the AdminService interface communicates with
 * the database by using a Spring Data JPA repository.
 * It Specifies methods used to obtain and modify over Admin and Mobile related information 
 * which is stored in the database.
 * @author Akash Karn
 */
@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IMobileDAO mobileDao;
	
	@Autowired
	private IAdminDAO adminDao;
	
	/**
     * Gets the full name of the person.
     * @return  The full name of the person.
     */
	@Override
	public Admin adminLogin(String username, String password) {
		
		Admin admin = new Admin();
		
		if(username.equals("admin") && password.equals("admin")) {
			admin.setUsername(username);
			admin.setPassword(password);
			admin.setServerResponse("Admin login successful...");
		}else {
			throw new InvalidCredentialsException("Invalid entries. "
					+ "Enter correct details...");
		}
		return admin;
	}

	@Override
	public List<Mobile> getMobiles() {
		List<Mobile> mobilesList = mobileDao.findAll();
		if(mobilesList != null) {
			return mobilesList;
		}else {
			throw new MobileNotFoundException("No mobiles found in database");
		}
	}

	@Override
	public Mobile addMobile(Mobile mobile) {
		if(mobile != null) {
			if(mobileDao.existsByModelIsNot(mobile.getModel())) {
				mobileDao.save(mobile);
				mobile.setServerResponse("Mobile added successfully");
				return mobile;
			}else {
				throw new AlreadyExistsException("Mobile already exists...!");
			}
		}else {
			throw new InvalidArgumentException("Getting null object");
		}
	}

	@Override
	public Mobile editMobile(Mobile mobile) {
		if(mobile != null) {
			mobileDao.save(mobile);
			mobile.setServerResponse("Mobile edited successfully");
			return mobile;
		}else {
			throw new InvalidArgumentException("Getting null object");
		}
	}

	@Override
	public Mobile deleteMobile(Mobile mobile) {
		Mobile newMobile = new Mobile(mobile.getBrandName(),
				mobile.getPrice(), mobile.getModel(), mobile.getOs(), mobile.getQty(),
				mobile.getYear());
		if(mobile != null) {
			newMobile.setMobId(mobile.getMobId());
			mobileDao.delete(mobile);
			newMobile.setServerResponse("Mobile deleted successfully...");
			return newMobile;
		}else {
			throw new InvalidArgumentException("Getting null object...");
		}
	}

	
}
