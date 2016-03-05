package com.rtms.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.rtms.model.system.BaseBusinessObject;

@Entity
@Table(name = "label_data")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Label extends BaseBusinessObject {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "label_code", length = 1024)
	private String labelCode;

	@Column(name = "label_value", length = 1024)
	private String labelValue;

	@Column(name = "locale", length = 50)
	private String locale;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabelCode() {
		return labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}

	public String getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
}
