package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.LrContaintDetails;

public interface LrContaintDetailsRepository extends JpaRepository<LrContaintDetails, Integer>{
	
	@Query(value="SELECT c.description,c.goods_id,c.no_of_containts,g.goods_name, c.detail_id, c.lr_header_id FROM t_lr_containt_details c, m_goods g WHERE g.goods_id=c.goods_id AND c.lr_header_id=:lrHeaderId" ,nativeQuery=true)
	List<LrContaintDetails> findByLrHeaderId(@Param("lrHeaderId") int lrHeaderId);

	
	
	
	
}
