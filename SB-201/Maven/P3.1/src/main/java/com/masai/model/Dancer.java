package com.masai.model;

import org.springframework.stereotype.Component;

@Component
public class Dancer implements ArtistManagement{
    @Override
    public void announceAvailability(String message) {
        System.out.println(message + " available for booking...");
    }
}
