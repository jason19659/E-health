package com.jason19659.ehealth.model;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.jason19659.ehealth.utils.JsonDateSerializer;

public class Medicinal {
    private String id;

    private String name;

    private String type;

    private String manufacturer;

    private String introduction;

    private BigDecimal price;

    private String detail;

    private Date pubdate;

    private String image;

    private Integer stock;

    private Integer sales;
    
    public void toAlert() {
    	if ("".equals(id)) {
			id = null;
		}
    	if ("".equals(name)) {
    		name = null;
		}
    	if ("".equals(type)) {
    		type = null;
		}
    	if ("".equals(manufacturer)) {
    		manufacturer = null;
		}
    	if ("".equals(introduction)) {
    		introduction = null;
		}
    	if ("".equals(price)) {
    		price = null;
		}
    	if ("".equals(detail)) {
    		detail = null;
		}
    	if ("".equals(image)) {
    		image = null;
		}
    	if ("".equals(stock)) {
    		stock = null;
		}
    	if ("".equals(sales)) {
    		sales = null;
		}
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getPubdate() {
        return pubdate;
    }

  
    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}