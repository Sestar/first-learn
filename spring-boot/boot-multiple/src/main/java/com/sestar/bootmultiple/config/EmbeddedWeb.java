package com.sestar.bootmultiple.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 嵌入式 Web 容器配置类, 模拟 Tomcat 配置
 *
 * @author zhangxinxin
 * @date 2019/9/8 19:33
 **/
@Configuration
public class EmbeddedWeb {

    /**
     * 嵌入式Servlet容器配置
     *
     * @author zhangxinxin
     * @date 2019/9/28 14:55
     * @return org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
     */
    @Bean
    public static EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {

        return new EmbeddedServletContainerCustomizer() {

            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                // Tomcat的Servlet服务配置工厂
                if (container instanceof TomcatEmbeddedServletContainerFactory) {
                    TomcatEmbeddedServletContainerFactory factory = TomcatEmbeddedServletContainerFactory.class.cast(container);
                    // Tomcat连接配置
                    factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {

                        @Override
                        public void customize(Connector connector) {
                            connector.setPort(3772);
                            connector.setProtocolHandlerClassName(Http11Nio2Protocol.class.getName());
                        }
                    });

                    // Tomcat对应的Web服务配置
                    factory.addContextCustomizers(new TomcatContextCustomizer() {
                        @Override
                        public void customize(Context context) {
                            context.setPath("/path");
                        }
                    });
                }
            }
        };

//        // Lambda写法
//        return container ->  {
//
//            if (container instanceof TomcatEmbeddedServletContainerFactory) {
//                TomcatEmbeddedServletContainerFactory factory = TomcatEmbeddedServletContainerFactory.class.cast(container);
//                factory.addConnectorCustomizers(connector -> {
//                    connector.setPort(3772);
//                    connector.setProtocolHandlerClassName(Http11Nio2Protocol.class.getName());
//                });
//
//                factory.addContextCustomizers(context -> context.setPath("/path"));
//            }
//        };

    }

}
