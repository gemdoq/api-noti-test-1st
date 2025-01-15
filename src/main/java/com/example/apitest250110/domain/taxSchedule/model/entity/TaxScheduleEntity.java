package com.example.apitest250110.domain.taxSchedule.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tax_schedule")
public class TaxScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String taxScheduleDate; // 세무일정
	private String taxContent;      // 세무내용
	private String remark;          // 비고

	public String getTaxScheduleDate() {
		return taxScheduleDate;
	}

	public void setTaxScheduleDate(String taxScheduleDate) {
		this.taxScheduleDate = taxScheduleDate;
	}

	public String getTaxContent() {
		return taxContent;
	}

	public void setTaxContent(String taxContent) {
		this.taxContent = taxContent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}