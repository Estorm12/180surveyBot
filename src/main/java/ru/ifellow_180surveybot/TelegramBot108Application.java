package ru.ifellow_180surveybot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TelegramBot108Application {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBot108Application.class, args);
    }

}
