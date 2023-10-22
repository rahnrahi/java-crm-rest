package com.rahi.crm.restapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rahi.crm.restapi.controller.Exception.CloudVendorNotFoundException;
import com.rahi.crm.restapi.model.CloudVendor;
import com.rahi.crm.restapi.repository.ICloudvendorRepository;
import com.rahi.crm.restapi.service.ICloudVendorService;

@Service
public class CloudVendorService implements ICloudVendorService {

    ICloudvendorRepository iCloudvendorRepository;

    public CloudVendorService(ICloudvendorRepository iCloudvendorRepository) {
        this.iCloudvendorRepository = iCloudvendorRepository;
    }

    @Override
    public UUID createCloudVendor(CloudVendor cloudVendor) {
        iCloudvendorRepository.save(cloudVendor);
        return cloudVendor.getVendorId();
    }

    @Override
    public Optional<CloudVendor> updateCloudVendor(UUID vendorId,CloudVendor cloudVendor) {
        Optional<CloudVendor> vendorEntity = iCloudvendorRepository.findById(vendorId);
        if (vendorEntity.isPresent()) {
            // Modify the fields of the entity object
            CloudVendor cvendor = vendorEntity.get();
            if(cloudVendor.getVendorName()!=null){
               cvendor.setVendorName(cloudVendor.getVendorName());
            }

            if(cloudVendor.getVendorAddress()!=null){
               cvendor.setVendorAddress(cloudVendor.getVendorAddress());
            }

            if(cloudVendor.getVendorPhoneNumber()!=null){
               cvendor.setVendorPhoneNumber(cloudVendor.getVendorPhoneNumber());
            }
            // Save the entity
            iCloudvendorRepository.save(cvendor);
        }
        return vendorEntity;
    }

    @Override
    public CloudVendor getCloudVendor(UUID vendorId) {
        var cloudVendorItem =  iCloudvendorRepository.findById(vendorId);
        if(cloudVendorItem.isEmpty()){
            throw new CloudVendorNotFoundException("Requested cloud vendor item not found.");
        }
        return cloudVendorItem.get();
    }

    @Override
    public String deleteCloudVendor(UUID vendorId) {
        iCloudvendorRepository.deleteById(vendorId);
        return "Deleted";
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return iCloudvendorRepository.findAll();
    }

}
