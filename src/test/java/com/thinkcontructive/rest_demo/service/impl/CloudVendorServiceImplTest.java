package com.thinkcontructive.rest_demo.service.impl;

import com.thinkcontructive.rest_demo.model.CloudVendor;
import com.thinkcontructive.rest_demo.repository.CloudVendorRepository;
import com.thinkcontructive.rest_demo.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1", "Amazon", "KENYA", "0789898989");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Cloud Vendor created successfully");
    }

    @Test
    void testUpdateCloudVendor() {
        // Mock existsById to return true
        when(cloudVendorRepository.existsById(cloudVendor.getVendorId())).thenReturn(true);
        // Mock save method
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        assertThat(cloudVendorService.updateCloudVendor(cloudVendor))
                .isEqualTo("Cloud Vendor updated successfully");
    }


    @Test
    void deleteCloudVendor() {
    }

    @Test
    void testGetCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("1").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());
    }

    @Test
    void getAllCloudVendors() {
    }
}