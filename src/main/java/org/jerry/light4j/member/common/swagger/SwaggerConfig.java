package org.jerry.light4j.member.common.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.switch}")
    private boolean swaggerSwitch;
	
	@Value("${swagger.version}")
    private String swaggerVersion;
	
	@Bean
	public Docket memberApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("member")
				.select()
				.paths(PathSelectors.ant("/member/**"))
				.build()
				.apiInfo(apiInfo())
				.enable(swaggerSwitch);
	}
	
	@Bean
	public Docket systemApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("system")
				.select()
				.paths(PathSelectors.ant("/system/**"))
				.build()
				.apiInfo(apiInfo())
				.enable(swaggerSwitch);
	}
	
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("openAPI服务")
				.version("版本号:"+swaggerVersion)
				.license("MIT License")
				.build();
	}
	

	  private ApiKey apiKey() {
	    return new ApiKey("mykey", "api_key", "header");
	  }

	  private SecurityContext securityContext() {
	    return SecurityContext.builder()
	        .securityReferences(defaultAuth())
	        .forPaths(PathSelectors.regex("/anyPath.*"))
	        .build();
	  }

	  public List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope
	        = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    List<SecurityReference> list = new ArrayList<SecurityReference>();
	    list.add(new SecurityReference("mykey", authorizationScopes));
	    return list;
	  }

	  @Bean
	  public SecurityConfiguration security() {
	    return SecurityConfigurationBuilder.builder()
	        .clientId("test-app-client-id")
	        .clientSecret("test-app-client-secret")
	        .realm("test-app-realm")
	        .appName("test-app")
	        .scopeSeparator(",")
	        .additionalQueryStringParams(null)
	        .useBasicAuthenticationWithAccessCodeGrant(false)
	        .build();
	  }
	
	/**
	 * 配置swagger-ui
	 * @return
	 */
	@Bean
	public UiConfiguration uiConfig() {
	    return UiConfigurationBuilder.builder()
	        .deepLinking(true)
	        .displayOperationId(false)
	        .defaultModelsExpandDepth(1)
	        .defaultModelExpandDepth(1)
	        .defaultModelRendering(ModelRendering.EXAMPLE)
	        .displayRequestDuration(false)
	        .docExpansion(DocExpansion.NONE)
	        .filter(false)
	        .maxDisplayedTags(null)
	        .operationsSorter(OperationsSorter.ALPHA)
	        .showExtensions(false)
	        .tagsSorter(TagsSorter.ALPHA)
	        .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
	        .validatorUrl(null)
	        .build();
	  }
}
