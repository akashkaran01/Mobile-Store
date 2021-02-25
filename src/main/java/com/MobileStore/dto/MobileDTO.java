package com.MobileStore.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A DTO class which is used for passing Mobile object data 
 * during interaction between client and server side.
 * @author Akash Karn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MobileDTO {
	
	Short mobId;
	String brandName;
	Integer price;
	String model;
	String os;
	Short qty;
	LocalDate year;

	String serverResponse;

}
