package com.egame.login;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


import egame.openapi.common.RequestParasUtil;

/**
 * Servlet implementation class CPServerDemo
 */
public class EgameLogin {

    public static void main(String[] args) throws IOException {       
        String code = "73c6be6152b6f7dbc350c290266e78ee";

        System.out.println("code=" + code);


            // CP服务器端授权码兑换令牌demo
        String content = null;

            // 授权码兑换令牌接口地址
        String url = "https://open.play.cn/oauth/token";

            // 注册时拿到的clientId
        String clientId = "84389942";

            // 注册时拿到的client_secret
        String clientSecret = "fbab84961aeb4b64b7df4200b8eef57d";

            // 请求参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("client_secret", clientSecret);

        System.out.println("url=" + url);
        System.out.println("params=" + params.toString());

        try {
                // 进行数字签名，并把签名相关字段放入请求参数MAP
            RequestParasUtil.signature("2", clientId, clientSecret, "MD5", "v1.0", params);

                // 发起请求
            content = RequestParasUtil.sendPostRequest(url, params);

                // CP服务器端私有逻辑，如判断用户是否为新用户，绑定用户信息等。

            System.out.println(content);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}