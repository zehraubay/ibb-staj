package com.example.StajEnvanterProjesi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class MessageHelper {

    @Autowired
    private MessageSource messageSource;

    public String get(String key, Object... args) {
        return messageSource.getMessage(key, args, Locale.getDefault());
    }
}