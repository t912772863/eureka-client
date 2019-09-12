package com.tian.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 使用Swagger2 动态生成api文档
 *
 *  * 启动后, 页面访问这个地址就可以看到接口api相关文档了
 * http://localhost:2001/swagger-ui.html
 *
 *
 * Created by z on 2019/9/12.
 */
@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档
public class Swagger2Config {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题：测试标题")
                        .description("描述：这是一个描述,具体包括XXX,XXX模块...")
                        .contact(new Contact("我是作者 ", null, null))
                        .version("版本号:1.0")
                        .build())
                .select()
                // 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.tian.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
