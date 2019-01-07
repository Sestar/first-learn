package com.sestar.springcloudconfigclient.damain;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description 测试获取segment.properties文件中的配置内容
 * @author zhangxinxin
 **/
@ConfigurationProperties(prefix = "segment.prop")
public class SegmentProp {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
