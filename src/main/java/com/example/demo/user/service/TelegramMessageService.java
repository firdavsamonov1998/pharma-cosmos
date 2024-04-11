package com.example.demo.user.service;


import com.example.demo.user.button.InlineButton;
import com.example.demo.user.message.SendMsg;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


public class TelegramMessageService {
    public static SendMessage selectLanguage(Long chatId) {
        return SendMsg.sendMsgInlineButton("*Assalomu alaykum  Pharma Cosmos  HR botiga xush kelibsiz! " +
                        "\n\nДобро пожаловать в HR бот компании Pharma Cosmos!*" +
                        "\n\n\uD83C\uDDFA\uD83C\uDDFF  *Iltimos o'zingizga qulay bo'lgan tilni tanlang* \n" +
                        "\n\uD83C\uDDF7\uD83C\uDDFA  *Пожалуйста, выберите предпочитаемый язык*", chatId,
                InlineButton.keyboardMarkup(InlineButton.rowList(InlineButton.row(
                        InlineButton.button("\n\uD83C\uDDFA\uD83C\uDDFFo'zbek tili", "uzbek"),
                        InlineButton.button("\uD83C\uDDF7\uD83C\uDDFArus tili", "rus")))));
    }


    public static SendMessage sendInfo(Long chatId) {
        return SendMsg.sendMsg("Почему мы?\n" +
                        "\n" +
                        "\uD83D\uDC69\u200D\uD83D\uDD2C Соучредителями компании являются врачи-клиницисты с" +
                        " большим стажем работы с пациентами и команда зарубежных технологов.\n\n\n" +
                        "\uD83E\uDDD1\uD83C\uDFFB\u200D\uD83D\uDD2C Миссия компании: Изменение отношения населения к " +
                        "местному производителю путём предоставления качественных препаратов при лечении различных заболеваний.\n\n\n" +
                        "\uD83C\uDFE5 Цель компании: предоставить населению инновационные препараты с высоким качеством.\n\n\n" +
                        "\uD83D\uDCCDНаш адресс  :  Ташкент, улица Фозилтепа, 261\n\n\n" +
                        "☎\uFE0FКонтакт : +998977316336"
                , chatId);
    }
}
