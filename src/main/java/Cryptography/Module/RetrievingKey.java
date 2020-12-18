package Cryptography.Module;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.List;

public class RetrievingKey {

    private KeyStore keyStore;
    private char[] password;
    private KeyStore.ProtectionParameter protectionParameter;
    private String Alias;

    public RetrievingKey(String algorithm) throws Exception {
        keyStore = KeyStore.getInstance(algorithm);
        this.password ="changeit".toCharArray();
        FileInputStream fileInputStream = new FileInputStream("C:/Program Files/Java/jdk-14.0.2/lib/security/cacerts");
        keyStore.load(fileInputStream,password);
        this.protectionParameter = new KeyStore.PasswordProtection(password);
    }

    public void CreateKey(String secretPassword,String algorithm,String Alias) throws KeyStoreException {
        this.Alias=Alias;
        SecretKey secretKey = new SecretKeySpec(secretPassword.getBytes(),algorithm);
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
        keyStore.setEntry(Alias,secretKeyEntry,protectionParameter);
    }

    public List<String> Retrieving(String keyStoreName) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(keyStoreName);
        keyStore.store(fileOutputStream,this.password);
        KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry(this.Alias,this.protectionParameter);
        SecretKey secretKey = secretKeyEntry.getSecretKey();
        List<String> keyDetail;
        keyDetail = Arrays.asList(secretKey.getAlgorithm(),secretKey.getFormat());
        return keyDetail;
    }

}
