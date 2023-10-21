package com.rahi.crm.restapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahi.crm.restapi.model.CloudVendor;

public interface ICloudvendorRepository extends JpaRepository<CloudVendor, UUID>{
    
}
