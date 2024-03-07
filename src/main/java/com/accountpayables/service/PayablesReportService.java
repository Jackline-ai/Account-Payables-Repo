package com.accountpayables.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.accountpayables.model.AccountPayablesReport;
import com.accountpayables.utils.Utilities;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class  PayablesReportService{
    	
      
	public String exportReport(String reportFormat,AccountPayablesReport accountPayablesReport) throws FileNotFoundException, JRException {

		String path = "/home/jackline/Desktop/Reports/";

		// Load the report template

		List<AccountPayablesReport> accountPayablesReports = new ArrayList<AccountPayablesReport>();
		accountPayablesReports.add(accountPayablesReport);

		File file = ResourceUtils.getFile("classpath:Account_Payable_Parent.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(accountPayablesReports);
		Map<String, Object> parameters = new HashMap<>();
		
		JRBeanCollectionDataSource dataSourceHeader = new JRBeanCollectionDataSource(accountPayablesReports);
		parameters.put("HEADER_DATASOURCE", dataSourceHeader);
		
		JRBeanCollectionDataSource dataSourceVendorsItems = new JRBeanCollectionDataSource(accountPayablesReports);
		parameters.put("VENDORS_ITEMS_DATASOURCE", dataSourceVendorsItems);
		
		JRBeanCollectionDataSource dataSourceAccountPayables = new JRBeanCollectionDataSource(accountPayablesReports);
		parameters.put("ACCOUNT_PAYABLES_NET_DATASOURCE", dataSourceAccountPayables);
		
		parameters.put("createdBy", "Jackline");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("xml")) {
			return JasperExportManager.exportReportToXml(jasperPrint);

		}

		else if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + Utilities.getCurrentDateTime());

		}

		return "report generated in path: " + path;
	}


}


