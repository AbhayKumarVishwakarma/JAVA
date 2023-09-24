package com.demo;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MethodOrder_LifeCyclePerClass_Test {

    StringBuffer buffer= new StringBuffer("");
    @AfterEach
    public void afterEach() {
        System.out.println("the state of the instance object is :"+buffer.toString());
    }

    @Order(4)
    @Test
    public void testA() {
        System.out.println("inside testA");
        buffer.append("4");
    }

    @Order(3)
    @Test
    public void testB() {
        System.out.println("inside testB");
        buffer.append("3");
    }

    @Order(1)
    @Test
    public void testC() {
        System.out.println("inside testC");
        buffer.append("1");
    }

    @Order(2)
    @Test
    public void testD() {
        System.out.println("inside testD");
        buffer.append("2");
    }

}
