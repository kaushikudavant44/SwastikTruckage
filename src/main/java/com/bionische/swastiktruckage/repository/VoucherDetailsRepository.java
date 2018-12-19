package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.swastiktruckage.mastermodel.VoucherDetails;

public interface VoucherDetailsRepository extends JpaRepository<VoucherDetails, Integer>{

	
	VoucherDetails save(VoucherDetails voucherDetails);

	@Query(value="SELECT * from t_voucher ORDER BY voucher_id DESC LIMIT 1",nativeQuery=true)
	VoucherDetails findLastRecord();
}
