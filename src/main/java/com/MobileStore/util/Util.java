package com.MobileStore.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.MobileStore.dto.MobileDTO;
import com.MobileStore.entity.Mobile;

public class Util {
	
	@Autowired
	private static ModelMapper modelMapper;
	
	public static MobileDTO convertToDto(Mobile mobile) {
	    MobileDTO mobileDto = modelMapper.map(mobile, MobileDTO.class);
	    return mobileDto;
	}
	
	public static Mobile convertToEntity(MobileDTO mobileDto) {
	    Mobile mobile = modelMapper.map(mobileDto, Mobile.class);
	    return mobile;
	}

}
