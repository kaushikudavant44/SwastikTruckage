package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.VoucherDetails;

public interface VoucherDetailsRepository extends JpaRepository<VoucherDetails, Integer>{

	
	VoucherDetails save(VoucherDetails voucherDetails);
}
