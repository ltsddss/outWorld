package com.lts.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {
    //进行数字签名的私钥
    private static final String secretKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9123456789asd";


    /**
     * 一个JWT实际上就是一个字符串，它由三部分组成，头部(Header)、载荷(Payload)与签名(Signature)
     */

    /**
     *
     * @param topic token的主题
     * @param account 用户的账号
     * @param pwd 用户的密码
     * @return 返回一个token秘钥存放在前端的cookie内
     */
    public static String acquireJWT(String topic,String account,String pwd)  {
        //生成jwt令牌
        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(topic)
                .claim("account", account)
                .claim("pwd",pwd)
                .signWith(SignatureAlgorithm.HS256, secretKey);
        return jwtBuilder.compact();
    }

    /**
     * 解析JWT字符串
     *
     * @param jwt 需要解析的秘钥
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) {
        System.out.println(JWTUtils.acquireJWT("用户", "123456", "123456a@"));
    }
}
