package com.sestar.springcloudconfigserver.config;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxinxin
 * @description 添加属性数据源(数据源加载阶段)
 **/
public class MyPropertiesLoader implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        // 如果是可配置的环境对象
        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment cast = ConfigurableEnvironment.class.cast(environment);
            MutablePropertySources propertySources = cast.getPropertySources();
            propertySources.addFirst(createPropertySource());
        }
        return null;
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
        properties.put("spring.application.id", "MyPropertiesLoader");
        // 返回Map类PropertySource数据源
        return new MapPropertySource("my-properties-create-property-source", properties);
    }

}
