package Cryptography.NotUnitTest;


import Cryptography.Module.Generator_Key;

import java.security.NoSuchAlgorithmException;

public class Generator_KeyTest {

    public static void main(String[] args) {
        try {
            Generator_Key generator_key = new Generator_Key("DES");
            System.out.println(generator_key.CreateKey());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
