package com.abd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Response {
    private String message;
    private List<String> choiceList;

    public Response(String message) {
        this.message = message;
        this.choiceList = new ArrayList<>();
    }
}

