package cn.uway.frame.util;

import org.apache.shiro.crypto.hash.Sha512Hash;

/**
 * Created by uwayxs on 2017/11/28.
 */
public class EncryptUtil {
    public static void main(String[] args) {
        System.out.println(new Sha512Hash("123456","admin",1024).toBase64());;
    }
}
