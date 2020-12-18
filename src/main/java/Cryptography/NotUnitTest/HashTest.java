package Cryptography.NotUnitTest;



import java.security.NoSuchAlgorithmException;
import java.security.Security;

import Cryptography.Module.Hash;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class HashTest {

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        try {
            Hash hash = new Hash("MD5");
            hash.update("JE-Chen");
            System.out.println(hash.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
