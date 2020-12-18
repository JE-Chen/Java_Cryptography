package Cryptography.Module;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AES {

    private KeyGenerator keyGenerator;
    private SecretKey secretKey;
    private SecretKeySpec secretKeySpec;
    private byte[] iv;

    public AES(String algorithm, int keySize) throws NoSuchAlgorithmException {
        this.init(algorithm, keySize);
    }

    public void init(String algorithm, int keySize) throws NoSuchAlgorithmException {
        keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(keySize, new SecureRandom());
        secretKey = keyGenerator.generateKey();
        iv = new byte[16];
        new SecureRandom().nextBytes(iv);
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public void setSecretKeySpec(String keySpec, String algorithm) {
        if (keySpec.length() != 16 || keySpec.length() != 24 || keySpec.length() != 32) {
            byte[] key = keySpec.getBytes();
            this.secretKeySpec = new SecretKeySpec(key, algorithm);
        }
    }

    public SecretKeySpec getSecretKeySpec() {
        return secretKeySpec;
    }

    public String aesEncrypt(String message, String algorithm, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] messageByte = message.getBytes();
        cipher.update(messageByte);
        return Base64.getEncoder().encodeToString(cipher.doFinal());
    }

    public byte[] aesEncrypt(byte[] message, String algorithm, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        cipher.update(message);
        return cipher.doFinal();
    }

    public String aesEncrypt(String message, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        byte[] messageByte = message.getBytes();
        cipher.update(messageByte);
        return Base64.getEncoder().encodeToString(cipher.doFinal());
    }

    public byte[] aesDecrypt(byte[] message, String algorithm, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        cipher.update(message);
        return cipher.doFinal();
    }

    public String aesDecrypt(String message, String algorithm, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] encryptString = Base64.getDecoder().decode(message.getBytes());
        cipher.update(encryptString);
        return new String(cipher.doFinal(), StandardCharsets.UTF_8);
    }

    public String aesDecrypt(String message, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        byte[] encryptString = Base64.getDecoder().decode(message.getBytes());
        cipher.update(encryptString);
        return new String(cipher.doFinal(), StandardCharsets.UTF_8);
    }

}
