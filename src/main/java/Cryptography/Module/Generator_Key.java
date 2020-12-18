package Cryptography.Module;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Generator_Key {

    private KeyGenerator keyGenerator;

    public Generator_Key(String algorithm) throws NoSuchAlgorithmException {
        keyGenerator = KeyGenerator.getInstance(algorithm);
        SecureRandom secureRandom = new SecureRandom();
        keyGenerator.init(secureRandom);
    }

    public Key CreateKey(){
        return keyGenerator.generateKey();
    }

}
