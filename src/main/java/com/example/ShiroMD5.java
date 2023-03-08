package com.example;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroMD5 {
    public static void main(String[] args) {
        String secret = "x11";
        Md5Hash md5Hash = new Md5Hash(secret);
        System.out.println(md5Hash);

        // 使用盐值加密
        Md5Hash md5Hash1 = new Md5Hash(secret, "java");
        // salt + 加密次数
        Md5Hash md5Hash2 = new Md5Hash(secret, "salt", 3);

        SimpleHash simpleHash = new SimpleHash("Md5", secret, "java", 3);


        System.out.println(md5Hash2);


        System.out.println(md5Hash1);
    }
}
