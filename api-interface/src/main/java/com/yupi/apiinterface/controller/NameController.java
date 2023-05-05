package com.yupi.apiinterface.controller;



import com.yupi.apiclientsdk.Utils.SignUtil;
import com.yupi.apiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getName(String name){
        return "你的名字是" + name;
    }

    @PostMapping("/")
    public String postName(@RequestParam String name){
        return "POST你的名字是" + name;
    }

    @PostMapping("/user")
    public String postNameJson(@RequestBody User user, HttpServletRequest request){
//        try {
//            String accessKey = request.getHeader("accessKey");
//            String nonce = request.getHeader("nonce");
//            String timestamp = request.getHeader("timestamp");
//            String sign = request.getHeader("sign");
//            //加密的时候用到是已经是utf-8的格式了
//            String body = URLDecoder.decode(request.getHeader("body"),"utf-8");
//            //todo 应该从数据库中获取分配给用户的密钥
//            if(!accessKey.equals("yupi")){
//                throw new RuntimeException("无权限！");
//            }
//            if(Long.parseLong(nonce) > 10000){
//                throw new RuntimeException("无权限！");
//            }
//            //todo 设定时间与当前时间不超过五分钟
//            //当前秒数
//            long now = System.currentTimeMillis() / 1000;
//            if (now - (Long.parseLong(timestamp)) > 300){
//                throw new RuntimeException("无权限");
//            }
//            //todo 从数据库查询 secretKey
//            Map<String, String> map = new HashMap<>();
//            map.put("accessKey","yupi");
//            map.put("nonce", nonce);
//            map.put("body",request.getHeader("body"));
//            map.put("timestamp",timestamp);
//            String serverSign = SignUtil.getSign(map, "abcdefg");
//            if(!sign.equals(serverSign)){
//                throw new RuntimeException("无权限！");
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String result ="POST_JSON你的名字是" + user.getUsername();
        System.out.println(result);
        //调用成功 次数+1
        return result;

    }
}
