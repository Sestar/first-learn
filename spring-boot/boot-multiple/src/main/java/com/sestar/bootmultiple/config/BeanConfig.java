package com.sestar.bootmultiple.config;

import com.sestar.bootmultiple.vo.UserVO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description 初始化 Bean
 * @author zhangxinxin
 * @date 2019/5/6 19:08
 **/
@Configuration
public class BeanConfig {

    @Configuration
    @ConditionalOnMissingBean(UserVO.class)
    protected static class UserVOConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public UserVO userVOInstance() {
            UserVO user = new UserVO();
            user.setName("format");
            user.setAge(10);

            return user;
        }

    }

}
