package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.LrGraph;

public interface LrGraphRepository extends JpaRepository<LrGraph, Integer>{
	
	@Query(value="SELECT days.day as lr_date, COUNT(t_lr_header.lr_header_id) as lr_count " + 
			"FROM " + 
			" (SELECT CURDATE() AS DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 1 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 2 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 3 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 4 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 5 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 6 DAY " +    
			"  UNION SELECT CURDATE() - INTERVAL 7 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 8 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 9 DAY " + 
			" UNION SELECT CURDATE() - INTERVAL 10 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 11 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 12 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 13 DAY  " + 
			"  UNION SELECT CURDATE() - INTERVAL 14 DAY " + 
			"  UNION SELECT CURDATE() - INTERVAL 15 DAY " + 
			" ) days " + 
			" LEFT JOIN t_lr_header " + 
			"  ON days.day = t_lr_header.lr_date AND t_lr_header.from_id=:fromId AND t_lr_header.is_used=TRUE " + 
			"GROUP BY " + 
			" days.day",nativeQuery=true)
	List<LrGraph> getLrCountAndLrDate(@Param("fromId")int fromId);

}
