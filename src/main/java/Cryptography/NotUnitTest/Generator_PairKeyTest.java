package Cryptography.NotUnitTest;



import Cryptography.Module.Generator_PairKey;

import java.security.NoSuchAlgorithmException;

public class Generator_PairKeyTest {

    public static void main(String[] args) {
        try {
            Generator_PairKey generator_pairKey = new Generator_PairKey("DSA",2048);
            System.out.println(generator_pairKey.CreatePrivateKey());
            System.out.println(generator_pairKey.CreatePublicKey());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
