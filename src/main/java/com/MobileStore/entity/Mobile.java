package com.MobileStore.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * An entity class which contains the information of a Mobile.
 * @author Akash Karn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "mobile")
public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Short mobId;
	
	@NonNull
	String brandName;
	
	@NonNull
	Integer price;
	
	@NonNull
	String model;
	
	@NonNull
	String os;
	
	@NonNull
	Short qty;
	
	@NonNull
	LocalDate year;
	
	@Transient
	String serverResponse;
}
