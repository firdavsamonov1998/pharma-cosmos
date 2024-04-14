package com.example.demo.user.service;


import com.example.demo.user.button.InlineButton;
import com.example.demo.user.message.SendMsg;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
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
        return SendMsg.sendMsg("Наша компания динамично развивающаяся компания и мы всегда рады, " +
                        "что вы выбираете нашу компанию \uD83D\uDE0A\uD83D\uDE0A" +
                        "\n\uD83D\uDCCDНаш адресс  :  Ташкент, улица Фозилтепа, 261\n" +
                        "☎\uFE0FКонтакт : +998977316336"
                , chatId);
    }


    public static SendLocation sendLocation(Long chatId) {
        return SendMsg.sendLocation(chatId);
    }

    public static SendMessage sendCreatedInfo(Long chatId) {
        return SendMsg.sendMsgParseMode("This bot created  by * Firdavs Amonov Rustamjon o'g'li*  especially  for * OOO PHARMA COSMOS *. " +
                " This Company is a rapidly developing pharmaceutical organization. Currently, there are more than 100 pharmacies belonging to the enterprise ." +
                "If your company needs such a telegram bot, please contact us" +
                "*\n\n\uD83D\uDCF1 Phone : +998900279803*" +
                "*\n\n\uD83C\uDF10Telegram : @firdavs_amonovv *", chatId);
    }
}
