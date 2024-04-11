package com.example.demo.user.util;


import com.example.demo.user.message.SendMsg;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ErrorMessage {
    public static SendMessage sendErrorMessage(Long chatId) {
        return SendMsg.sendMsg("Noto'g'ri buyruq shakli", chatId);
    }
}
