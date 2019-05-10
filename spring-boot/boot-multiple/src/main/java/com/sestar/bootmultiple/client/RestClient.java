package com.sestar.bootmultiple.client;

import com.sestar.bootmultiple.vo.UserVO;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @description Rest Client
 * @author zhangxinxin
 * @date 2019/5/6 11:14
 **/
public class RestClient {

    /**
     * @description 用 Rest 方式访问
     * @author zhangxinxin
     * @date 2019/5/6 11:25
     */
    public static void main(String[] args) throws Exception {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        CloseableHttpClient httpClient = httpClientBuilder.build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

        RestTemplate restTemplate = new RestTemplate(factory);

//        ResponseEntity<UserVO> rsp = restTemplate.exchange("http://localhost:3771/simple/user/check",
//                HttpMethod.HEAD, null, UserVO.class, new HashMap<>());

        HttpHeaders httpHeaders = restTemplate.headForHeaders("http://localhost:3771/simple/user/check", new HashMap<>());

        Assert.isTrue(httpHeaders.getContentLength() > 0, "No bean have been found: " + UserVO.class.getName());
    }

}
