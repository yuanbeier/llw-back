package com.ybe.llwback.util;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: beier
 * @date: 2020/9/13
 * @description: 自定义加解密的类
 * @version: 1.0
 */
public class AESBCryptPasswordEncoder extends BCryptPasswordEncoder {
    /**
     * 重写验证方法
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    @SneakyThrows
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String decrypt = AesEncryptUtils.deEncrypt(rawPassword.toString());
        return super.matches(decrypt.trim(),encodedPassword.trim());
    }


}
