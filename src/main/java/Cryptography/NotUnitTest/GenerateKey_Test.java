package Cryptography.NotUnitTest;


import Cryptography.Module.GenerateKey;

public class GenerateKey_Test {
    public static void main(String[] args) {
        try {
            GenerateKey generateKey = new GenerateKey("JCEKS");
            generateKey.createKey("TestPassword","DSA","TestAlias", "java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
