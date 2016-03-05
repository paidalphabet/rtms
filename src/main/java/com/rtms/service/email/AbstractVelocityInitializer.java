package com.rtms.service.email;

import java.io.StringReader;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;

import com.rtms.dao.BaseDAO;
import com.rtms.entity.email.EmailTemplate;
import com.rtms.framework.bo.factory.ApplicationContextFactory;
import com.rtms.framework.bo.factory.BOFactory;
import com.rtms.framework.exception.RTMSException;

public abstract class AbstractVelocityInitializer {

	protected VelocityEngine velocityEngine;
	protected VelocityContext velocityContext;

	protected void init() {
		velocityEngine = BOFactory.getVelocityEngine();
		velocityEngine.init();
		velocityContext = new VelocityContext();

	}

	protected void populateVelocityContext(final Map<String, String> emailExtendedProperties, final VelocityContext velocityContext) {
		final Set<String> keySet= emailExtendedProperties.keySet();
		for(final String key : keySet){
			final String keyValue = emailExtendedProperties.get(key);
			velocityContext.put(key, keyValue);
		}		
	}

	protected Template getTemplate(String templateID) throws RTMSException{
		final Template template = new Template();
		final RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
		final BaseDAO baseDao = (BaseDAO) ApplicationContextFactory.getAppcontext().getBean("basedao");
		final EmailTemplate emailTemplate = (EmailTemplate) baseDao.getObjectByID(EmailTemplate.class, Integer.parseInt(templateID));
		if(null != emailTemplate){
			try {
				final SimpleNode node  = RuntimeSingleton.parse(new StringReader(emailTemplate.getTemplateContent()),emailTemplate.getTemplateName());
				template.setData(node);
				template.setRuntimeServices(runtimeServices);
				template.initDocument();
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
			return template;
		}else{
			return null;
		}
	}
}
