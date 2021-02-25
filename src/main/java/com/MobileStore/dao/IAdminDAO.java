package com.MobileStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MobileStore.entity.Admin;

/**
 * Specifies methods used to obtain and modify Admin related information
 * which is stored in the database.
 * @author Akash Karn
 */
@Repository
public interface IAdminDAO extends JpaRepository<Admin, String> {

}
