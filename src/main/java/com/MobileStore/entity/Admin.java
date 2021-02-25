package com.MobileStore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * An entity class which contains the information of an Admin.
 * @author Akash Karn
 */
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	String username;
	String password;
	
	@Transient
	String serverResponse;
	
}
