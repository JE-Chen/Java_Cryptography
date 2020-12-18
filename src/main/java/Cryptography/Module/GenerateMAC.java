package Cryptography.Module;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.Key;
import java.security.SecureRandom;

public class GenerateMAC {

    private KeyGenerator keyGenerator;
    private Key key;
    private Mac mac;

    public GenerateMAC(String keyAlgorithm, String macAlgorithm) throws java.security.GeneralSecurityException {
        keyGenerator = KeyGenerator.getInstance(keyAlgorithm);
        SecureRandom secureRandom = new SecureRandom();
        keyGenerator.init(secureRandom);
        key = keyGenerator.generateKey();
        mac = Mac.getInstance(macAlgorithm);
        mac.init(key);
    }

    public String computingMac(String message){
        byte[] bytes = message.getBytes();
        byte[] macResult = mac.doFinal(bytes);
        return new String(macResult);
    }
}
