package zhuo.ssm_test.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String PasswordEncoderUtil (String str){
        String encode = bCryptPasswordEncoder.encode(str);
        return encode;
    }

}
