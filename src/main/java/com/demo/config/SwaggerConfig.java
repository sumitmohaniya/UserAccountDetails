package com.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.demo.feign.FeignInterface;


@Configuration
public class SwaggerConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	
	
	/*
	 * @Bean public DataSource dataSource() { BasicDataSource dataSource = new
	 * BasicDataSource(); dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * System.out.println("1111111");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/sumit");
	 * dataSource.setUserName("root"); dataSource.setPassword("root"); return
	 * dataSource; }
	 * 
	 * @Bean(name = "entityManagerFactory") public
	 * LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() { final
	 * LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new
	 * LocalContainerEntityManagerFactoryBean();
	 * entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
	 * entityManagerFactoryBean.setDataSource(dataSource());
	 * System.out.println("2222222222222");
	 * entityManagerFactoryBean.setPersistenceProviderClass(
	 * HibernatePersistenceProvider.class);
	 * entityManagerFactoryBean.setPackagesToScan("com.demo.*");
	 * entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties()); return
	 * entityManagerFactoryBean; }
	 * 
	 * protected Properties jpaHibernateProperties() {
	 * 
	 * final Properties properties = new Properties();
	 * 
	 * properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
	 * properties.put("hibernate.show_sql", true);
	 * properties.put("hibernate.format_sql", true);
	 * properties.put("hibernate.ddl-auto","create");
	 * 
	 * return properties; }
	 * 
	 * 
	 * @Bean public HibernateJpaVendorAdapter vendorAdaptor() { final
	 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	 * return vendorAdapter; }
	 */

}
