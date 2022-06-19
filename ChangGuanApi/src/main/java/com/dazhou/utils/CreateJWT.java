package com.dazhou.utils;

import com.dazhou.entity.AdminInfoEntity;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateJWT {
    public static String getToken(AdminInfoEntity adminInfo){
        Map<String, Object> tokenData = new HashMap<>();
        Jwts.parser();//解密
        tokenData.put("jobNum",adminInfo.getJobNum());
        tokenData.put("name",adminInfo.getName());
        tokenData.put("role",adminInfo.getRole());
        JwtBuilder jwtBuilder=Jwts.builder()
                .setId(adminInfo.getId()+"")//设置需要加密的内容
//                .setSubject(adminInfo.getJobNum())
                .setClaims(tokenData)
                .setIssuedAt(new Date())//token保留时间
                .signWith(SignatureAlgorithm.HS256,"my-123").setExpiration(
                        new Date(new Date().getTime()+86400000)
                );
//        System.out.println(jwtBuilder.compact());
        return jwtBuilder.compact();
    }

}
