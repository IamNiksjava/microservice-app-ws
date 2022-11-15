package com.appblog.ws.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig  {

	@Bean
	public RequestMappingHandlerAdapter requestHandler() {
	    RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    List<MediaType> mediaTypeList = new ArrayList<>();
	    mediaTypeList.add(MediaType.APPLICATION_JSON);
	    converter.setSupportedMediaTypes(mediaTypeList);
	    adapter.getMessageConverters().add(converter);
	    return adapter;
	}
	
	@Bean
    public Docket apiDocket() {
		   String groupName = "FFF";
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.appblog.ws.ui.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName(groupName).apiInfo(apiInfo());
    }
	
	  private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("store-swagger")
	                .description("store-swagger-endpoint")
	                .version("1.0.0")
	                .license("vvv")
	                .build();
	    }
	  
}