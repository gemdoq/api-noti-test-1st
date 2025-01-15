package com.example.apitest250110.domain.taxSchedule.model.dto;

import java.time.LocalDate;
import java.util.List;

public class TaxScheduleEmailRequest {
	private List<String> emailAddresses;
	private LocalDate startDate;
	private LocalDate endDate;

	public TaxScheduleEmailRequest() {
	}

	public TaxScheduleEmailRequest(List<String> emailAddresses, LocalDate startDate, LocalDate endDate) {
		this.emailAddresses = emailAddresses;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public List<String> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}
