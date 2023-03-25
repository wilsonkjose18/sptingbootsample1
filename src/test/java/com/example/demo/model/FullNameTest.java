package com.example.demo.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FullNameTest {

    @Test
    void reversetestnormal1() {

        FullName fn = new FullName("Mr. Wilson Jose");
        Assertions.assertEquals("Jose,Mr. Wilson", fn.getReversedName());

    }
}
