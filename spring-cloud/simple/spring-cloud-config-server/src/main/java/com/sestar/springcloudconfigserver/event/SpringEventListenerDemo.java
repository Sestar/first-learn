package com.sestar.springcloudconfigserver.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxinxin
 * @description Spring 事件/监听 Demo
 */
public class SpringEventListenerDemo {

    public static void main(String[] args) {
        // 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 增加监听器
        context.addApplicationListener(new MyApplicationListener());
        // 上下文启动
        context.refresh();

        // 发布事件
        context.publishEvent(new MyApplicationEvent("Hello World"));
        context.publishEvent(new MyApplicationEvent(1));
        context.publishEvent(new MyApplicationEvent(1.1D));
    }

    /**
     * 监听器Demo
     */
    private static class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

        @Override
        public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
            System.out.printf("MyApplicationEvent receives event source: %s \n", myApplicationEvent.getSource());
        }
    }

    /**
     * 事件Demo
     */
    private static class MyApplicationEvent extends ApplicationEvent {

        public MyApplicationEvent(Object source) {
            super(source);
        }
    }

}
