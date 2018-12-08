package com.bionische.swastiktruckage.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer>{
	
	Goods save(Goods goods);
	
	List<Goods> findByIsUsedOrderByGoodsIdDescIsUsed(boolean isUsed);
	
	Goods findByGoodsId(int goodsId);
			
	@Transactional
	@Modifying
	@Query("UPDATE Goods o SET o.isUsed=false  WHERE o.goodsId=:goodsId")
	int removeGoodsByGoodsId(@Param("goodsId")int goodsId);
}
