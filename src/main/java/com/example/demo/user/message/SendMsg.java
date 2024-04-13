package com.example.demo.user.message;

import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class SendMsg {
    public static SendMessage sendMsg(String txt, Long chatId) {
        return new SendMessage(String.valueOf(chatId), txt);
    }

    public static SendMessage sendMsgInlineButton(String txt, Long chatId, InlineKeyboardMarkup inlineKeyboardMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        sendMessage.setChatId(chatId);
        sendMessage.setText(txt);
        sendMessage.setParseMode("Markdown");
        return sendMessage;
    }


    public static EditMessageText sendMsgEditeParseMode(String txt, Long chatId, Integer messageId) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);
        editMessageText.setText(txt);
        editMessageText.setParseMode("Markdown");
        return editMessageText;
    }

    public static SendMessage sendMsgParseMode(String txt, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(txt);
        sendMessage.setChatId(chatId);
        sendMessage.setParseMode("Markdown");
        return sendMessage;
    }

    public static EditMessageText sendMsgEditeButton(String txt, Long chatId, Integer messageId, InlineKeyboardMarkup markup) {
        EditMessageText editMessageText = sendMsgEditeParseMode(txt, chatId, messageId);
        editMessageText.setReplyMarkup(markup);
        return editMessageText;
    }

    public static SendLocation sendLocation(Long chatId) {
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.297703);
        sendLocation.setLongitude(69.181142);
        return sendLocation;
    }
}
