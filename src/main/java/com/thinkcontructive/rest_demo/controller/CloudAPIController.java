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
    public ResponseEntity<List<CloudVendor>>  getAllCloudVendorDetails() {
        return ResponseEntity.ok(cloudVendorService.getAllCloudVendors());
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<CloudVendor> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
            return ResponseEntity.ok(cloudVendorService.getCloudVendor(vendorId));
    }

    @PostMapping
    public ResponseEntity<CloudVendor> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {

        cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseEntity.status(201).body(cloudVendor);
    }

    @PutMapping("{vendorId}")
    public ResponseEntity<CloudVendor> updateCloudVendorDetails(@PathVariable String vendorId,
                                           @RequestBody CloudVendor cloudVendor) {
        cloudVendor.setVendorId(vendorId);
        cloudVendorService.updateCloudVendor(cloudVendor);
        return ResponseEntity.ok(cloudVendor);
    }


    @DeleteMapping("{vendorId}")
    public ResponseEntity<Void> deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {

        cloudVendorService.deleteCloudVendor(vendorId);
        return ResponseEntity.noContent().build();
    }

}
