package Cryptography.Module;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class Decrypting {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public Decrypting(String algorithm,int keySize) throws NoSuchAlgorithmException {
        this.init(algorithm, keySize);
    }

    public void init(String algorithm,int keySize) throws NoSuchAlgorithmException {
        keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(keySize);
        keyPair = keyPairGenerator.generateKeyPair();
        privateKey = this.getPrivateKey();
        publicKey = this.getPublicKey();
    }

    public PublicKey getPublicKey(){
        return keyPair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    public byte[] decryptData(String data, String algorithm,PublicKey publicKey) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE,publicKey);
        byte[] dataByte = data.getBytes();
        dataByte = Base64.getDecoder().decode(dataByte);
        cipher.update(dataByte);
        return cipher.doFinal();
    }

}
