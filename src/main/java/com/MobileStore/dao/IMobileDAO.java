package com.MobileStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MobileStore.entity.Mobile;

/**
 * Specifies methods used to obtain and modify Mobile related information
 * which is stored in the database.
 * @author Akash Karn
 */
@Repository
public interface IMobileDAO extends JpaRepository<Mobile, Short> {
	
	Boolean existsByModelIsNot(String model);

}
