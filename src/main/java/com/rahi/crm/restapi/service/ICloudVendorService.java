package com.rahi.crm.restapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rahi.crm.restapi.model.CloudVendor;

public interface ICloudVendorService {
    public UUID createCloudVendor(CloudVendor cloudVendor);
    public Optional<CloudVendor> updateCloudVendor(UUID vendorId,CloudVendor cloudVendor);
    public CloudVendor getCloudVendor(UUID vendorId);
    public String deleteCloudVendor(UUID vendorId);
    public List<CloudVendor> getAllCloudVendor();

}
