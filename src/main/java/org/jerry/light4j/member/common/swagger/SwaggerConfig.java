package org.jerry.light4j.member.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket memberImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("member")
				.select().paths(PathSelectors.ant("/member/**")).build()
				.apiInfo(apiInfo());
	}
	
	
	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger - API文档神器").build();
	}
}
