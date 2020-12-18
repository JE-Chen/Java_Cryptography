package Cryptography.Module;

import java.security.*;

public class Generator_PairKey {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;

    public Generator_PairKey(String algorithm,int keySize) throws NoSuchAlgorithmException {
        keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(keySize);
        keyPair = keyPairGenerator.generateKeyPair();
    }

    public PrivateKey CreatePrivateKey(){
        return keyPair.getPrivate();
    }

    public PublicKey CreatePublicKey(){
        return keyPair.getPublic();
    }

}
