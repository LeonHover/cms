package io.github.leonhover.cms.infra.swagger;

import org.w3c.dom.DocumentType;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.web.bind.annotation.RestController;

/**
 * SwaggerConfiguration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
                .build();
    }

}