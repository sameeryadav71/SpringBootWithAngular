package com.web.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author s.yadav
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.web"))
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo getApiInfo() {
        Contact contact = new Contact("Sameer Yadav", "https://github.com/sameeryadav71", "sameer@gmail.com");
        return new ApiInfoBuilder()
                .title("User Service API")
                .description("Documentation for user service")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }
}