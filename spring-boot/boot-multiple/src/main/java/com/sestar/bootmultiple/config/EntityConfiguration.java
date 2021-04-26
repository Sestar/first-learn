package com.sestar.bootmultiple.config;

import com.sestar.bootmultiple.domain.vo.UserVO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * 实体类配置
 *
 * @author zhangxinxin
 * @date 2019/5/6 19:08
 */
@Configuration
public class EntityConfiguration {

    /**
     * UserVO Bean, 用以存储 UserVO 的 Link
     *
     * @author zhangxinxin
     * @date 2019/5/21 10:43
     */
    @Bean
    @ConditionalOnMissingBean(UserVO.class)
    public UserVO userVoInstance() {
        UserVO user = new UserVO();
        user.setName("format");
        user.setAge(10);
        user.setBirthday(new Date());

        return user;
    }

}
