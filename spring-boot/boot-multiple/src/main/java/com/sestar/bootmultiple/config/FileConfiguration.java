package com.sestar.bootmultiple.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 文件配置
 *
 * @author zhangxinxin
 * @date 2019/5/6 19:08
 */
@Configuration
public class FileConfiguration {

    @Component
    public static class DocumentDirectoryCustomizer implements EmbeddedServletContainerCustomizer {

        /**
         * 读取配置中的 tomcat-embed-jasper 的 documentRoot
         */
        @Value("${tomcat.documentRoot}")
        private String documentRoot;

        @Override
        public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
            // 设置 tomcat 的 documentRoot
            configurableEmbeddedServletContainer.setDocumentRoot(new File(documentRoot));
        }

    }

}
