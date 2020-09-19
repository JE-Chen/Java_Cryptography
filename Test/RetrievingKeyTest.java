package com.je_chen.Test;

import com.je_chen.Cryptography.RetrievingKey;

public class RetrievingKeyTest {

    public static void main(String[] args) {
        try {
            RetrievingKey retrievingKey = new RetrievingKey("JCEKS");
            retrievingKey.CreateKey("TestPassword","DSA","TestAlias");
            for(String Detail : retrievingKey.Retrieving("Test")){
                System.out.println(Detail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
