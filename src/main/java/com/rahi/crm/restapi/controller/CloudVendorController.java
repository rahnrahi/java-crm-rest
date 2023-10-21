package com.rahi.crm.restapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahi.crm.restapi.model.CloudVendor;
import com.rahi.crm.restapi.service.impl.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;
    
    public CloudVendorController(CloudVendorService cloudVendorService) {
      this.cloudVendorService = cloudVendorService;
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorService.getAllCloudVendor();
    }

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") UUID vendorId) {
        return cloudVendorService.getCloudVendor(vendorId);
    }

    @PostMapping()
    public UUID createCloudVendor(@RequestBody CloudVendor cloudVendor){
      return cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping("{vendorId}")
    public Optional<CloudVendor> updateCloudVendor(@PathVariable("vendorId") UUID vendorId, @RequestBody CloudVendor cloudVendor){
      return cloudVendorService.updateCloudVendor(vendorId, cloudVendor);
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") UUID vendorId) {
          return cloudVendorService.deleteCloudVendor(vendorId);
    }

}
