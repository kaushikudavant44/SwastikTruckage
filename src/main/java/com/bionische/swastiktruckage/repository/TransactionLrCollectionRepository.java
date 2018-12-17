package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.TransactionLrCollection;


public interface TransactionLrCollectionRepository extends JpaRepository<TransactionLrCollection, Integer>{
	
	TransactionLrCollection save(TransactionLrCollection transactionLrCollection);
	
	TransactionLrCollection findByCollectionId(int collectionId);
	
	@Query(value="select * from t_lr_collection where create_date between :fromDate and :toDate" ,nativeQuery=true)
	List<TransactionLrCollection> collectionBillByDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
