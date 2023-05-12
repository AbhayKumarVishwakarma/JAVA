package com.masai.model;

import org.springframework.stereotype.Component;

@Component
public class Actor implements ArtistManagement{
    @Override
    public void announceAvailability(String message) {
        System.out.println(message + " available for booking...");
    }
}
