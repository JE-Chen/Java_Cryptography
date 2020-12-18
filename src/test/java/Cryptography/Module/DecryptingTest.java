package Cryptography.Module;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

class DecryptingTest {

    @Test
    void testDecrypting(){
        try {
            Encrypting encrypting = new Encrypting("RSA",2048);
            String encryptString = new String(encrypting.encryptData("JE-Chen","RSA/ECB/PKCS1Padding"), StandardCharsets.UTF_8);
            System.out.println(encryptString);
            Decrypting decrypting = new Decrypting("RSA",2048);
            System.out.println(new String(decrypting.decryptData(encryptString,"RSA/ECB/PKCS1Padding",encrypting.getPublicKey()), StandardCharsets.UTF_8));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}