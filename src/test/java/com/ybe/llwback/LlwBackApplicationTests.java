package com.ybe.llwback;

import com.ybe.llwback.util.AESBCryptPasswordEncoder;
import com.ybe.llwback.util.AesEncryptUtils;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class LlwBackApplicationTests {

    @Autowired
    AESBCryptPasswordEncoder aesbCryptPasswordEncoder ;

    @Test
    void contextLoads() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        boolean matches = aesbCryptPasswordEncoder.matches("lBTqrKS0kZixOFXeZ0HRng==", "$2a$10$Iu6FJWbSGxGPbqEuatZouei3rmGAn55pm/sb3JW6J3/JuI/sbLbXi");
        System.out.println("matches:" + matches);
        System.out.println(System.currentTimeMillis()-currentTimeMillis);
    }

}
