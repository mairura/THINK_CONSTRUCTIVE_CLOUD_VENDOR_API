package com.thinkcontructive.rest_demo.controller;

import com.thinkcontructive.rest_demo.model.CloudVendor;
import com.thinkcontructive.rest_demo.response.ResponseHandler;
import com.thinkcontructive.rest_demo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudVendor")
public class CloudAPIController {

    CloudVendorService cloudVendorService;

    public CloudAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping()
    public ResponseEntity<Object>  getAllCloudVendorDetails() {
        return ResponseHandler.responseBuilder("List of all Cloud Vendors",
                HttpStatus.OK,
                cloudVendorService.getAllCloudVendors()
        );
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        return ResponseHandler.responseBuilder("Requested Vendor details are given here",
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId)
        );
    }

    @PostMapping
    public ResponseEntity<Object> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseHandler.responseBuilder("Vendor Created successfully",
                HttpStatus.CREATED,
                cloudVendor
        );
    }

    @PutMapping("{vendorId}")
    public ResponseEntity<Object> updateCloudVendorDetails(@PathVariable String vendorId,
                                           @RequestBody CloudVendor cloudVendor) {
        cloudVendor.setVendorId(vendorId);
        cloudVendorService.updateCloudVendor(cloudVendor);
        return ResponseHandler.responseBuilder("Vendor updated successfully",
                HttpStatus.OK,
                cloudVendor
        );
    }

    @DeleteMapping("{vendorId}")
    public ResponseEntity<Object> deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return ResponseHandler.responseBuilder("Vendor deleted successfully",
                HttpStatus.OK, null);
    }

}
