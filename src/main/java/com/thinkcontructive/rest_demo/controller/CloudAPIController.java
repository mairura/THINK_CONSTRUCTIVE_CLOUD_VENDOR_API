package com.thinkcontructive.rest_demo.controller;

import com.thinkcontructive.rest_demo.model.CloudVendor;
import com.thinkcontructive.rest_demo.response.ResponseHandler;
import com.thinkcontructive.rest_demo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler.responseBuilder("Requested Vendor details are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));

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
