package com.pingyougou.shopweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by tanwen on 2018/11/17.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/seller/register").setViewName("register");
        registry.addViewController("/seller/home").setViewName("shoplogin");
        registry.addViewController("/seller/goods").setViewName("goods_edit");
        registry.addViewController("/seller/toGoods").setViewName("goods");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }
}
