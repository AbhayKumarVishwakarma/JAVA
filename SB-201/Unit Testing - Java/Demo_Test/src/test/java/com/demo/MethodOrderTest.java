package com.demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderTest {

    @Order(4)
    @Test
    public void testA() {
        System.out.println("inside testA");
    }
    @Order(3)
    @Test
    public void testB() {
        System.out.println("inside testB");
    }
    @Order(1)
    @Test
    public void testC() {
        System.out.println("inside testC");
    }
    @Order(2)
    @Test
    public void testD() {
        System.out.println("inside testD");
    }

}
