package com.example.demo.user.main;

import com.example.demo.user.controller.CallBackQueryMessageController;
import com.example.demo.user.controller.MainController;
import com.example.demo.user.service.TelegramMessageService;
import com.example.demo.user.util.ErrorMessage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MyTelegramBot extends TelegramLongPollingBot {

    private final MyTelegramBot myTelegramBot;
    private final CallBackQueryMessageController queryMessageController;
    private final MainController controller;


    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage()) {
            Message message = update.getMessage();


            if (message.hasText() && message.getText().equals("/start")) {
                controller.handle(message, "");
                return;
            }
            if (message.hasText() && message.getText().equals("/info")) {
                myTelegramBot.sendMessage(TelegramMessageService.sendInfo(message.getChatId()));
                return;
            }
            controller.handle(message, "");
        } else if (update.hasCallbackQuery()) {
            queryMessageController.callBackMessage(update.getCallbackQuery());
        } else {
            sendMessage(ErrorMessage.sendErrorMessage(update.getMessage().getChatId()));
        }
    }


    public void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }


    public void sendEditeMessage(EditMessageText editMessageText) {
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


   @Lazy
    public MyTelegramBot(TelegramBotsApi telegramBotsApi, MyTelegramBot myTelegramBot,
                         CallBackQueryMessageController queryMessageController,
                         MainController controller) throws TelegramApiException {
        super("6915584304:AAF8jqqtYdA9Q3kkkHke4L-oemR5g2Qhl_8");
        this.myTelegramBot = myTelegramBot;
        this.queryMessageController = queryMessageController;
        this.controller = controller;
        telegramBotsApi.registerBot(this);
    }

    @Override
    public String getBotUsername() {
        return "@pharmacosmos_hr_bot";
    }


}
