package ru.ifellow_180surveybot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeyboardService {


    public ReplyKeyboardMarkup getMainReplyKeyboard(){
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Заполнить новую анкету"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Активные анкеты"));
        row2.add(new KeyboardButton("Все анкеты"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Помощь"));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        return replyKeyboardMarkup;
    }

}
