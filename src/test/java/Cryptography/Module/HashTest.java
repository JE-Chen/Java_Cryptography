package Cryptography.Module;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.Security;

class HashTest {

    @Test
    void testHash(){
        Security.addProvider(new BouncyCastleProvider());
        try {
            Hash hash = new Hash("MD5");
            hash.update("JE-Chen");
            System.out.println(hash.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}