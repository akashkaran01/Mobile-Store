package com.MobileStore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A DTO class which is used for passing Admin object data 
 * during interaction between client and server side.
 * @author Akash Karn
 */
@Data
@NoArgsConstructor
@ToString
public class AdminDTO {
	
	String username;
	String password;
	
	String serverResponse;

}
