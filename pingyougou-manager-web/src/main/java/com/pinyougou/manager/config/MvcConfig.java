package com.pinyougou.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by tanwen on 2018/11/14.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/template/page").setViewName("type_template");
        registry.addViewController("/specification/page").setViewName("specification");
        registry.addViewController("/brand/page").setViewName("brand");
        registry.addViewController("/seller/page").setViewName("seller_1");
        registry.addViewController("/type/item_cat").setViewName("item_cat");

        //广告模块
        registry.addViewController("/content/content").setViewName("content");
        registry.addViewController("/content/category").setViewName("content_category");

        registry.addViewController("/home").setViewName("home");

        registry.addViewController("/").setViewName("index");

        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
    }
}
