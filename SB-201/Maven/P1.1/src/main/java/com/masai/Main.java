package com.masai;

import com.masai.utils.EMUtils;

import javax.persistence.EntityManager;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManager em = EMUtils.getEntityConnection();
    }
}