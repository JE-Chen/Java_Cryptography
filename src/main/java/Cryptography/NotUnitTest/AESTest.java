package Cryptography.NotUnitTest;

import Cryptography.Module.AES;

import java.nio.charset.StandardCharsets;

public class AESTest {

    public static void main(String[] argv){
        try {
            String data = "JE-Chen";
            AES aes = new AES("AES",256);
            String encryptString =(aes.aesEncrypt(data,"AES/CBC/PKCS5PADDING",aes.getSecretKey()));
            System.out.println(encryptString);
            System.out.println(aes.aesDecrypt(encryptString,"AES/CBC/PKCS5PADDING",aes.getSecretKey()));

            System.out.println();

            byte[] dateByte = aes.aesEncrypt(data.getBytes(),"AES/CBC/PKCS5PADDING",aes.getSecretKey());
            System.out.println(new String(dateByte,StandardCharsets.UTF_8));
            System.out.println(new String(aes.aesDecrypt(dateByte,"AES/CBC/PKCS5PADDING",aes.getSecretKey()),StandardCharsets.UTF_8));

            System.out.println();

            aes.setSecretKeySpec("1234567891234567","AES");
            String encryptString1 = aes.aesEncrypt(data,"AES/CBC/PKCS5PADDING");
            System.out.println(encryptString1);
            System.out.println(aes.aesDecrypt(encryptString1,"AES/CBC/PKCS5PADDING"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
