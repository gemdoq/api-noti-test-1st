package com.example.apitest250110.domain.taxSchedule.service;

import com.example.apitest250110.domain.taxSchedule.model.entity.TaxScheduleEntity;
import com.example.apitest250110.domain.taxSchedule.repository.TaxScheduleRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaxScheduleService {

	@Value("${MAIL_USERNAME}")
	private String MAIL_USERNAME;

	private final TaxScheduleRepository taxScheduleRepository;
	private final JavaMailSender mailSender;
	private final TemplateEngine templateEngine;

	public TaxScheduleService(TaxScheduleRepository taxScheduleRepository, JavaMailSender mailSender, TemplateEngine templateEngine) {
		this.taxScheduleRepository = taxScheduleRepository;
		this.mailSender = mailSender;
		this.templateEngine = templateEngine;
	}

	public void sendEmailsWithFilteredData(
			List<String> emailAddresses,
			LocalDate startDate,
			LocalDate endDate
	) {
		String startDateString = startDate.toString();
		String endDateString = endDate.toString();

		// 1. DB에서 시작일~종료일 사이 데이터를 필터링
		List<TaxScheduleEntity> schedules = taxScheduleRepository.findAllByScheduleDateBetween(startDateString, endDateString);

		if (schedules.isEmpty()) {
			throw new RuntimeException("필터링된 데이터가 없습니다.");
		}

		// 2. 데이터를 Thymeleaf에 사용할 Map으로 변환
		Map<String, Object> emailData = new HashMap<>();
		emailData.put("schedules", schedules);

		// 3. 이메일 주소 순회하며 전송
		for (String email : emailAddresses) {
			sendEmail(email, emailData);
		}
	}

	public void sendEmail(String to, Map<String, Object> emailData) {
		try {
			// 1. Thymeleaf 템플릿 렌더링
			Context context = new Context();
			context.setVariables(emailData);
			String htmlContent = templateEngine.process("tax_schedule_template", context);

			// 2. 이메일 생성
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setTo(to);
			helper.setSubject("세무 일정 알림");
			helper.setText(htmlContent, true);
			helper.setFrom(MAIL_USERNAME);

			// 3. 이메일 전송
			mailSender.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException("이메일 전송 중 오류 발생: " + e.getMessage(), e);
		}
	}
}
