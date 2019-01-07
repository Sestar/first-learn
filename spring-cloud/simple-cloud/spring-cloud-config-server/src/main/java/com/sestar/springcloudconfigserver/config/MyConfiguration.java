package com.sestar.springcloudconfigserver.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxinxin
 * @description 添加属性数据源(上下文初始化阶段)
 **/
public class MyConfiguration implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 获取上下文的环境配置对象
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // 获取环境配置源
        MutablePropertySources propertySources = environment.getPropertySources();
        // 添加自己的属性配置
        propertySources.addFirst(createPropertySource());
    }

    /**
     * @return org.springframework.core.env.PropertySource
     * @description 自定义数据propertySource
     * @author zhangxinxin
     * @date 2018/12/19 16:54
     **/
    private PropertySource createPropertySource() {
        // property属性内容
        Map<String, Object> properties = new HashMap<>();
        properties.put("spring.application.id", "MyConfiguration");
        // 返回Map类PropertySource数据源
        return new MapPropertySource("my-configuration-create-property-source", properties);
    }

}
