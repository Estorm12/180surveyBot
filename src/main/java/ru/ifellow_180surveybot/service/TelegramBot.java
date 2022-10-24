package ru.ifellow_180surveybot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.ifellow_180surveybot.config.BotConfig;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;
    private ExecutorService executorService;

    public TelegramBot(BotConfig config){
        this.config = config;
    }

    @PostConstruct
    private void postConstruct() {
        executorService = new ThreadPoolExecutor(config.getMaxThreadSize(), config.getMaxThreadSize(),
                5000L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(config.getQueueSize(), true), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @PreDestroy
    public void preDestroy() {
        executorService.shutdown();
    }
    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    @Transactional
    public void onUpdateReceived(Update update) {
        executorService.execute(()->processUpdate(update));
    }

    public void processUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText(messageText);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }
}
