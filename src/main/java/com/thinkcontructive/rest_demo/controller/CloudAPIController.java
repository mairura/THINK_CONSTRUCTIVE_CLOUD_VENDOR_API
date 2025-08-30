package com.thinkcontructive.rest_demo.controller;

import com.thinkcontructive.rest_demo.model.CloudVendor;
import com.thinkcontructive.rest_demo.service.CloudVendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudAPIController {

    CloudVendorService cloudVendorService;

    public CloudAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails() {
        return cloudVendorService.getAllCloudVendors();
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<CloudVendor> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
            CloudVendor vendor = cloudVendorService.getCloudVendor(vendorId);
            return ResponseEntity.ok(vendor);
    }

    @PostMapping
    public ResponseEntity<CloudVendor> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {

        cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseEntity.status(201).body(cloudVendor);
    }

    @PutMapping("{vendorId}")
    public String updateCloudVendorDetails(@PathVariable String vendorId,
                                           @RequestBody CloudVendor cloudVendor) {
        cloudVendor.setVendorId(vendorId);
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }


    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {

        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }

}
