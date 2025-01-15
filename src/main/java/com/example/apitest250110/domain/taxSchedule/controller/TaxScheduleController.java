package com.example.apitest250110.domain.taxSchedule.controller;

import com.example.apitest250110.domain.taxSchedule.model.dto.TaxScheduleEmailRequest;
import com.example.apitest250110.domain.taxSchedule.service.TaxScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tax-schedule")
public class TaxScheduleController {

	@Autowired
	private TaxScheduleService taxScheduleService;

	@PostMapping("/send-email")
	public String sendEmails(@RequestBody TaxScheduleEmailRequest taxScheduleEmailRequest) {
		List<String> emailList = taxScheduleEmailRequest.getEmailAddresses();
		LocalDate startDate = taxScheduleEmailRequest.getStartDate();
		LocalDate endDate = taxScheduleEmailRequest.getEndDate();
		taxScheduleService.sendEmailsWithFilteredData(emailList, startDate, endDate);
		return "이메일 전송 완료";
	}
}
