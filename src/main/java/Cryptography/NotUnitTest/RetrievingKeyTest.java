package Cryptography.NotUnitTest;

import Cryptography.Module.RetrievingKey;

public class RetrievingKeyTest {

    public static void main(String[] args) {
        try {
            RetrievingKey retrievingKey = new RetrievingKey("JCEKS");
            retrievingKey.CreateKey("TestPassword","DSA","TestAlias");
            for(String Detail : retrievingKey.Retrieving("java")){
                System.out.println(Detail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
