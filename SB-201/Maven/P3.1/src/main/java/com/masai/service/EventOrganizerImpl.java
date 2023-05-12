package com.masai.service;

import com.masai.model.ArtistManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDate;

@Service
@Lazy(value = true)
public class EventOrganizerImpl implements EventOrganizer{
    @Autowired(required = false)
    @Qualifier("singer")
    ArtistManagement artistManagement;

    public ArtistManagement getArtistManagement() {
        return artistManagement;
    }

    public void setArtistManagement(ArtistManagement artistManagement) {
        this.artistManagement = artistManagement;
    }

    public void findArtist(String message){
        // Code Logic
        artistManagement.announceAvailability(message);
    }
    @PostConstruct
    public void printInfo(){
        System.out.println("Event data is " + LocalDate.now());
        System.out.println("Event venue is Lucknow");
    }

    @PreDestroy
    public void ending(){
        System.out.println("Thankyou for Attending the Event");
    }
}
