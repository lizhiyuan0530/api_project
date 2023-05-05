package com.yupi.apiinterface;

import com.yupi.apiclientsdk.client.ApiClient;
import com.yupi.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClient apiClient;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("影");
        String result = apiClient.postNameJson(user);
        System.out.println(result);
    }

}
