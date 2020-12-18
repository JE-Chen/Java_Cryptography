package Cryptography.Module;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class Encrypting {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public Encrypting(String algorithm,int keySize) throws NoSuchAlgorithmException {
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

    public byte[] encryptData(String data,String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE,privateKey);
        byte[] dataByte = data.getBytes();
        cipher.update(dataByte);
        return Base64.getEncoder().encode(cipher.doFinal());
    }

}
