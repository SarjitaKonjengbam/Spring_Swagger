package com.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackages="com.demo")
public class SwaggerConfig extends WebMvcConfigurationSupport
{
	private static final String swagger_Api_version="1.0";
	private static final String license="license";
	private static final String title="Swagger_Api";
	private static final String description="Swagger Demo";
	
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder()
				.title(title)
				.license(license)
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Sarjita Konj", "https://springframework.guru/about/", "sarjitakonjengbam20@gmail.com"))
				.version(swagger_Api_version)
				.description(description)
				.build();
		
	}
	
	@Bean
	public Docket productsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				.paths(Predicates.not(PathSelectors.regex("/error"))) 
				.build();
	}
	//optional for demo
	@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
