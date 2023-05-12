package com.masai.usecase;

import com.masai.service.EventOrganizer;
import com.masai.service.EventOrganizerImpl;
import com.masai.util.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        EventOrganizer eventOrganizer = applicationContext.getBean(EventOrganizerImpl.class);
        eventOrganizer.findArtist("Singer");
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}