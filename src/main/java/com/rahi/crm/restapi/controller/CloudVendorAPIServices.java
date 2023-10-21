package com.rahi.crm.restapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahi.crm.restapi.model.CloudVendor;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIServices {

    CloudVendor cloudVendor;
    
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId) {
        return cloudVendor;
    }

    @PostMapping()
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
      this.cloudVendor = cloudVendor;
      return cloudVendor.getVendorId();
    }

    @PutMapping()
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor){
      this.cloudVendor = cloudVendor;
      return cloudVendor.getVendorId();
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(String vendorId) {
        this.cloudVendor = null;
        return "Deleted successfully";
    }

}
