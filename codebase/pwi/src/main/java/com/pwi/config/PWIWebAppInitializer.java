package com.pwi.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PWIWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { PWIConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { PWIWebConfigurerAdapter.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}
