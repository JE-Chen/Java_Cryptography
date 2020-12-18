package Cryptography.Module;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    private MessageDigest messageDigest;

    public Hash(String algorithm) throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance(algorithm);
    }

    public void update(String message){
        messageDigest.update(message.getBytes());
    }

    public String digest(){
        byte[] digest = messageDigest.digest();
        StringBuffer hexString = new StringBuffer();
        for(int i=0;i<digest.length;i++){
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        return hexString.toString();
    }

}
