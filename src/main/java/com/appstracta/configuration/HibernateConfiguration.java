package com.appstracta.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	private Logger log = Logger.getLogger(getClass().getName());

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.appstracta.model");
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		JndiTemplate jndiTemplate = new JndiTemplate();
		DataSource dataSource = null;

		try {
			dataSource = (DataSource) jndiTemplate.lookup("java:/dsSakila");
		} catch (Exception ex) {
			log.error("Oucrrió un error al obtener el DataSource", ex);
		}

		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "validate");

		return properties;
	}
}
