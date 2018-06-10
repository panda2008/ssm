package com.pjq.ssm.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerUI配置
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages ={"com.pjq.ssm.controller"})  //制定扫描的controller包路劲
public class SwaggerConfig  extends WebMvcConfigurerAdapter {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
                .apiInfo(apiInfo())
                // select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现
                .select()
                // 扫描指定包内所有Controller定义的Api，并产生文档内容（除了被@ApiIgnore指定的请求）
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
    /*
     * "标题 title",
     * "描述 description", 
     * "termsOfServiceUrl", 
     * "联系邮箱 contact email",
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SSM API")
                .description("Android & IOS & H5 API Decument")
                .termsOfServiceUrl("https://www.pjq.com")
                .version("1.0")
                .build();
    }

}