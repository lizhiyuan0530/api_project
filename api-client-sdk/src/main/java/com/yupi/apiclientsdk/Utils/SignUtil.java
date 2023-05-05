package com.yupi.apiclientsdk.Utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

import java.util.Map;

public class SignUtil {
    /**
     * 生成签名
     * @param map
     * @param secretKey
     * @return
     */
    public static String getSign(Map<String, String> map, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String context = map.toString()+"-"+secretKey;
        return md5.digestHex(context);
    }
}
