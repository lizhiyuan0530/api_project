package com.yupi.apiclientsdk.client;




import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yupi.apiclientsdk.model.User;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.yupi.apiclientsdk.Utils.SignUtil.getSign;

/**
 * 调用第三方接口客户端
 */

//晚上用restTenplent改
public class ApiClient {

    public static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public void getName(String name){
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST+ "/api/name/", params);
        System.out.println(result);
    }


    public void postName(String name){
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", name);
        String result= HttpUtil.post(GATEWAY_HOST+"/api/name/", params);
        System.out.println(result);
    }

    private Map<String, String> getHeaderMap(String body){
        Map<String, String> map = new HashMap<>();
        try {
            map.put("accessKey",accessKey);
            //不能放到body里面发送
            //map.put("secretKey","abaaba");
            map.put("nonce", RandomUtil.randomNumbers(4));
            map.put("body", URLEncoder.encode(body,"utf-8"));
            //总秒数
            map.put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));
            map.put("sign", getSign(map,secretKey));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }



    public String postNameJson(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .contentType("application/json")
                .charset(StandardCharsets.UTF_8)
                .execute();
        String result = response.body();
        return result;
    }

}
