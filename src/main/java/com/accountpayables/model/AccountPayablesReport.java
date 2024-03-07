package com.accountpayables.model;

import java.util.List;

public class AccountPayablesReport {
	private Long id;
	private String tradeName;
	private String address;
	private String city;
	private String date;
	private String clientInfo;
	private String name;
	private String clientAddress;
	private String email;
	private String tel;
	private String payablesInfo;
	private List<AccountPayablesItems>items;
	private double totalPayables;
	private double totalPaymentsMade;
	private double netPayables;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public List<AccountPayablesItems> getItems() {
		return items;
	}
	public void setItems(List<AccountPayablesItems> items) {
		this.items = items;
	}
	public double getTotalPayables() {
		return totalPayables;
	}
	public void setTotalPayables(double totalPayables) {
		this.totalPayables = totalPayables;
	}
	public double getTotalPaymentsMade() {
		return totalPaymentsMade;
	}
	public void setTotalPaymentsMade(double totalPaymentsMade) {
		this.totalPaymentsMade = totalPaymentsMade;
	}
	public double getNetPayables() {
		return netPayables;
	}
	public void setNetPayables(double netPayables) {
		this.netPayables = netPayables;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPayablesInfo() {
		return payablesInfo;
	}
	public void setPayablesInfo(String payablesInfo) {
		this.payablesInfo = payablesInfo;
	}

}
