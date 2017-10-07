package com.alibaba.finnova.sample;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Configuration
	@EnableSwagger2
	public class SwaggerConfig {
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.select()
					.paths(paths())
					.build();
		}

		private Predicate<String> paths() {
			return PathSelectors.regex("(/v1/.*)");
		}

		private ApiInfo apiInfo() {
			List<VendorExtension> vendorExtensionList = new ArrayList<>();
			ApiInfo apiInfo = new ApiInfo(
					"Sample Service",
					"API Documentation for Sample Service",
					"",
					"",
					"",
					"",
					"");
		return apiInfo;
		}
	}
}
