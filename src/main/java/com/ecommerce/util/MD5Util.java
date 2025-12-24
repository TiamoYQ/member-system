package com.ecommerce.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    private static final String SALT = "ecommerce_2024"; // 盐值

    public static String encrypt(String password) {
        if (password == null || password.isEmpty()) {
            return "";
        }
        String firstMd5 = DigestUtils.md5Hex(password);
        return DigestUtils.md5Hex(firstMd5 + SALT);
    }
}