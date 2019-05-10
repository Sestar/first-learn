package com.sestar.bootmultiple.controller;

import com.sestar.bootmultiple.dao.UserDAO;
import com.sestar.bootmultiple.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @description Simple Controller
 * @author zhangxinxin
 * @date 2019/4/28 19:51
 **/
@RestController
@RequestMapping("/simple")
public class SimpleController {

    /**
     * 用户
     */
    private UserVO userVO;

    @Autowired
    public SimpleController(UserVO userVO) {
        this.userVO = userVO;
    }

    /**
     * @description 获取用户的超媒体API(hateoas)
     * @author zhangxinxin
     * @date 2019/5/6 10:39
     * @return com.sestar.bootmultiple.vo.UserVO
     */
    @GetMapping(path = "/json/hypermediaApi/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO hypermediaAPIOfUser() {
        return userVO;
    }

    /**
     * @description 以 Json 格式输出 UserVO 对象
     * @author zhangxinxin
     * @date 2019/5/3 14:39
     */
    @GetMapping(path = "/json/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO printUserByJson() {
        userVO.setName("json");

        return userVO;
    }

    /**
     * @description 以 Xml 格式输出 UserVO 对象, 需要依赖 jackson-dataformat-xml
     *      用 IE 访问，如果用 google 会有样式错误问题
     * @author zhangxinxin
     * @date 2019/5/3 14:39
     */
    @GetMapping(path = "/xml/user", produces = MediaType.APPLICATION_XML_VALUE)
    public UserVO printUserByXml() {
        userVO.setName("xml");

        return userVO;
    }

    /**
     * @description 修改用户姓名
     * @author zhangxinxin
     * @date 2019/5/6 10:38
     * @param name 修改后的姓名
     * @return com.sestar.bootmultiple.vo.UserVO
     */
    @PutMapping(path = "/user/change/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO changeUserName(@PathVariable("name") String name) {
        userVO.setName(name);
        userVO.add(linkTo(methodOn(SimpleController.class).changeUserName(userVO.getName())).withSelfRel());

        return userVO;
    }

    /**
     * @description 修改用户年龄
     * @author zhangxinxin
     * @date 2019/5/6 10:38
     * @param age 修改后的年龄
     * @return com.sestar.bootmultiple.vo.UserVO
     */
    @PutMapping(path = "/user/change/age/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO changeUserAge(@PathVariable("age") Integer age) {
        userVO.setAge(age);
        userVO.add(linkTo(methodOn(SimpleController.class).changeUserAge(userVO.getAge())).withSelfRel());

        return userVO;
    }

    /**
     * @description 用 Head 方式验证 userVO 的 bean 是否存在
     *      Head方法一般用来检查对象是否存在, Content-Length = 0 -> 不存在
     * @author zhangxinxin
     * @date 2019/5/6 10:47
     * @return boolean
     */
    @RequestMapping(path = "/user/check", method = RequestMethod.HEAD)
    public UserDAO checkUser() {
//        return userVO;
        return null;
    }

}
