package Cryptography.Module;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

class Generator_PairKeyTest {

    @Test
    void generator_PairKey(){
        try {
            Generator_PairKey generator_pairKey = new Generator_PairKey("DSA",2048);
            System.out.println(generator_pairKey.CreatePrivateKey());
            System.out.println(generator_pairKey.CreatePublicKey());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}