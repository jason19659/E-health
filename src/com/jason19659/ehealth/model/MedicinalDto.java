/**
 * 
 */
package com.jason19659.ehealth.model;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 *         com.jason19659.ehealth.model
 *
 *         2015年4月24日
 */
public class MedicinalDto {
	private String id;

	private String name;
	private String introduction;
	private BigDecimal price;
	private Integer amount;
	public MedicinalDto() {
		
	}
	public MedicinalDto(Medicinal m) {
		id = m.getId();
		name = m.getName();
		introduction = m.getIntroduction();
		price = m.getPrice();
		amount = 1;
	}
	public MedicinalDto(String id, String name, String introduction,
			BigDecimal price, Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.price = price;
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
