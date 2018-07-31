package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
@Bean
     public Docket getAPIDocket(){  //创建Swagger容器
    return new Docket(DocumentationType.SWAGGER_2)//设置文档类型
               .apiInfo(apiInfo())//api的相关描述信息，通常显示在页面的最上方
               .select()//返回一个ApiSelectorBuilder，用来构建api容器
               .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))//设置扫描的包
               .paths(PathSelectors.any())//设置扫描那些controller，这里设置扫描全部，可以传入正则表达式
               .build();//构建api容器           
     }
     private ApiInfo apiInfo(){
    return new ApiInfoBuilder()
   // .title("标题")//标题
    .description("使用swagger生成功能强大的API")//描述
 //   .contact("联系信息")//联系信息
    .version("1.0")//版本，除此之外还可以设置服务条款，license等信息。
    .build();
     }
}
