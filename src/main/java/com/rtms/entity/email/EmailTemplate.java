package com.rtms.entity.email;

import javax.persistence.Cacheable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.rtms.model.system.BaseBusinessObject;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class EmailTemplate extends BaseBusinessObject {

	private int templateID;
	private String templateName;
	private String templateContent;
	private String locale;

	public int getTemplateID() {
		return templateID;
	}

	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}