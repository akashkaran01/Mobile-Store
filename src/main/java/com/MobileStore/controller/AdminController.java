package com.MobileStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MobileStore.dto.MobileDTO;
import com.MobileStore.entity.Admin;
import com.MobileStore.entity.Mobile;
import com.MobileStore.service.AdminServiceImpl;
import com.MobileStore.util.Util;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	/**
     * This method is for Admin Login
     * @param username and password
     * @return response to server(Admin)
     */
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<Admin> adminLogin(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		Admin result = adminService.adminLogin(username, password);
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(result, HttpStatus.OK);
		return response;
	}
	
	/**
     * Gets list of mobiles
     * @param @NoArgs
     * @return List of mobiles
     */
	@GetMapping("/mobiles")
	public ResponseEntity<List<Mobile>> getMobiles(){
		List<Mobile> result = adminService.getMobiles();
		ResponseEntity<List<Mobile>> response = 
				new ResponseEntity<List<Mobile>>(result, HttpStatus.OK);
		return response;
	}
	
	/**
     * Used to add Mobile in the database
     * @param MobileDTO
     * @return MobileDTO
     */
	@PostMapping("/addMobile")
	public ResponseEntity<MobileDTO> addMobile(MobileDTO mobileDto){
		Mobile mobile = adminService.addMobile(Util.convertToEntity(mobileDto));
		MobileDTO result = Util.convertToDto(mobile);
		ResponseEntity<MobileDTO> response = 
				new ResponseEntity<MobileDTO>(result, HttpStatus.OK);
		return response;
	}
	
	/**
     * Used to edit Mobile in the database
     * @param MobileDTO
     * @return MobileDTO
     */
	@PutMapping("/editMobile")
	public ResponseEntity<MobileDTO> editMobile(MobileDTO mobileDto){
		Mobile mobile = adminService.editMobile(Util.convertToEntity(mobileDto));
		MobileDTO result = Util.convertToDto(mobile);
		ResponseEntity<MobileDTO> response = 
				new ResponseEntity<MobileDTO>(result, HttpStatus.OK);
		return response;
	}
	
	/**
     * Used to delete Mobile in the database
     * @param MobileDTO
     * @return MobileDTO
     */
	@PutMapping("/deleteMobile")
	public ResponseEntity<MobileDTO> deleteMobile(MobileDTO mobileDto){
		Mobile mobile = adminService.deleteMobile(Util.convertToEntity(mobileDto));
		MobileDTO result = Util.convertToDto(mobile);
		ResponseEntity<MobileDTO> response = 
				new ResponseEntity<MobileDTO>(result, HttpStatus.OK);
		return response;
	}
	
}
