package com.example.apitest250110.domain.taxSchedule.model.entity;

import jakarta.persistence.*;

@Entity
@Data
@Table(name = "tb_tax_schedule")
public class TaxScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String taxScheduleDate; // 세무일정
	private String taxContent;      // 세무내용
	private String remark;          // 비고
}