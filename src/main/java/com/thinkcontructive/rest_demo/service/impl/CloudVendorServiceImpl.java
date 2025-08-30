package com.thinkcontructive.rest_demo.service.impl;

import com.thinkcontructive.rest_demo.model.CloudVendor;
import com.thinkcontructive.rest_demo.repository.CloudVendorRepository;
import com.thinkcontructive.rest_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    // Final for immutability
    private final CloudVendorRepository cloudVendorRepository;

    // Constructor Injection
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Cloud Vendor created successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
       if(cloudVendorRepository.existsById(cloudVendor.getVendorId())) {
           cloudVendorRepository.save(cloudVendor);
           return "Cloud Vendor updated successfully";
       }

       throw new RuntimeException("Cloud Vendor not found with id: " + cloudVendor.getVendorId());
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.existsById(cloudVendorId)) {
            cloudVendorRepository.deleteById(cloudVendorId);
            return "Deleted Successfully";
        }

        throw new RuntimeException("Cloud Vendor not found with id: "+ cloudVendorId);
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return cloudVendorRepository.findById(cloudVendorId).orElseThrow(() -> new RuntimeException("Cloud Vendor not found with id: " + cloudVendorId));
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
