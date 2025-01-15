package com.example.apitest250110.domain.taxSchedule.repository;

import com.example.apitest250110.domain.taxSchedule.model.entity.TaxScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaxScheduleRepository extends JpaRepository<TaxScheduleEntity, Long> {

	@Query("SELECT t FROM TaxScheduleEntity t WHERE t.taxScheduleDate BETWEEN :startDate AND :endDate")
	List<TaxScheduleEntity> findAllByScheduleDateBetween(
			@Param("startDate") String startDate,
			@Param("endDate") String endDate
	);
}
