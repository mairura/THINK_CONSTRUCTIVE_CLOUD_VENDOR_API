package com.thinkcontructive.rest_demo.repository;

import com.thinkcontructive.rest_demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
}
