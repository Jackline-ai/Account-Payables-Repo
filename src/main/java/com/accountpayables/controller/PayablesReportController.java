package com.accountpayables.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountpayables.model.AccountPayablesReport;
import com.accountpayables.model.ApiResponse;
import com.accountpayables.service.PayablesReportService;

import net.sf.jasperreports.engine.JRException;
@RestController
@RequestMapping("/api")
public class PayablesReportController {
	@Autowired
	PayablesReportService payablesReportService;
	
	@PostMapping("/vendor-report")
	public ResponseEntity<ApiResponse> saveEtimsData(@RequestBody AccountPayablesReport accountPayablesReport) {
		ApiResponse response = new ApiResponse("Invoice printed successfully", 200);
		
		try {
			payablesReportService.exportReport("pdf", accountPayablesReport);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(response);
	}
}
