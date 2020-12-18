package Cryptography.Module;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

class Generator_KeyTest {

    @Test
    void testGenerator_Key() {
        try {
            Generator_Key generator_key = new Generator_Key("DES");
            System.out.println(generator_key.CreateKey());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}