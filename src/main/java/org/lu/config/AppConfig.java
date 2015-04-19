package org.lu.config;

import javax.annotation.PostConstruct;

import org.lu.jms.config.JmsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml",
		"classpath:META-INF/cxf/cxf-extension-xml.xml",
		"classpath:META-INF/cxf/cxf-servlet.xml",
		"classpath:org/lu/application.xml" })
@Import(value = { DataBaseConfig.class, JmsConfig.class })
public class AppConfig {
	@PostConstruct
	public void initialize() {
		System.out.println("web service up");
	}
}
