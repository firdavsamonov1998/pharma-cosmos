package com.example.demo.user.service;


import com.example.demo.user.button.InlineButton;
import com.example.demo.user.message.SendMsg;
import com.example.demo.user.util.ButtonName;
import com.example.demo.user.util.Profile;
import com.example.demo.user.util.SmsUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public class UserServiceUzb {
    
    public static EditMessageText getUserNameUz(Long chatId, Integer messageId) {
        return SendMsg.sendMsgEditeParseMode("Iltimos ism va familiyangizni kiriting : \n" +
                "*Masalan : Amonov Firdavs*", chatId, messageId);
    }

    public static SendMessage getPhoneNumberUz(Long chatId, Integer messageId) {
        return SendMsg.sendMsgParseMode("Iltimos telefon raqamingizni quyidagi tartibda kiriting :\n" +
                "*Masalan : +998900279803*", chatId);

    }

    public static SendMessage getDataUz(Long chatId) {
        return SendMsg.sendMsgInlineButton("*Iltimos ma'lumotingizni tanlang* \uD83D\uDC47 ", chatId,
                InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("Oliy ma'lumot", ButtonName.institute_uz)),
                        InlineButton.row(InlineButton.button("O'rta maxsus", ButtonName.colledge_uz)),
                        InlineButton.row(InlineButton.button("Talaba", ButtonName.unfinished_uz)))));

    }

    public static EditMessageText getProfessionUz(Long chatId, Integer messageId) {

        return SendMsg.sendMsgEditeButton("*Iltimos vakansiya turini tanlang* \uD83D\uDC47 ",
                chatId, messageId, InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("Dorixona mudiri", ButtonName.menejer_uz)),
                        InlineButton.row(InlineButton.button("Farmatsevt", ButtonName.pharma_uz)),
                        InlineButton.row(InlineButton.button("Praktikant", ButtonName.practician_uz)),
                        InlineButton.row(InlineButton.button("Dostavchik", ButtonName.dostavchik_uz)),
                        InlineButton.row(InlineButton.button("Sklad ishchisi", ButtonName.sklad_uz)),
                        InlineButton.row(InlineButton.button("Otdel pradaja parafarma", ButtonName.prodaja_uz))
                )));

    }


    public static EditMessageText getExperience(Long chatId, Integer messageId) {

        return SendMsg.sendMsgEditeButton("*Iltimos tajribangizni tanlang* \uD83D\uDC47 ",
                chatId, messageId, InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("0 - 1 yil", ButtonName.one_year_uz)),
                        InlineButton.row(InlineButton.button("1 - 3 yil", ButtonName.two_year_uz)),
                        InlineButton.row(InlineButton.button("3 - 5 yil", ButtonName.three_year_uz)),
                        InlineButton.row(InlineButton.button("5 yil va undan yuqori", ButtonName.five_year_uz
                        )))));
    }

    public static EditMessageText claimMessageUz(Profile profile, Long chatId, Integer messageId) {

        return SendMsg.sendMsgEditeButton("\t\t\t\t*Iltimos Amaliyotni tasdiqlang *\uD83D\uDC47 " +
                        "\n\n\n*Ismi :* " + profile.getFullName() + "" +
                        "\n\n*Telefon raqami :* " + profile.getPhone() + "" +
                        "\n\n*Ma'lumoti :* " + profile.getData() + "" +
                        "\n\n*vakansiya : *" + profile.getProfession() +
                        "\n\n*Tajribasi : *" + profile.getExp() +
                        "\n\n*Rus tili  : *" + profile.getLanguage(), chatId, messageId,
                InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("Tasdiqlash", "claim_uz"))
                )));

    }

    public static SendMessage sendToAdmin(Profile profile, Long chatId) {
        return SendMsg.sendMsgParseMode(
                "*\t\t\t\tVakansiya bo'yicha xodim*" +
                        "\n\n*Ism :* " + profile.getFullName() +
                        "\n\n*Telefon raqami :* " + profile.getPhone() +
                        "\n\n*Ma'lumoti : *" + profile.getData() +
                        "\n\n*vakansiya :* " + profile.getProfession() +
                        "\n\n*Tarjriba yili :* " + profile.getExp()
                        + "\n\n*Rus tili : *" + profile.getLanguage()
                  , chatId
        );
    }

    public static void sendSmsToAdmin(Profile profile) {
        SmsUtil.sendSmsCode("+998977316336",
                "\n\nIsm :" + profile.getFullName() +
                        "\n\nTelefon raqami : " + profile.getPhone() +
                        "\n\nMa'lumoti : " + profile.getData() +
                        "\n\nvakansiya : " + profile.getProfession() +
                        "\n\nTarjriba yili : " + profile.getExp() +
                        "\n\nRus tili : " + profile.getLanguage());
    }

    public static EditMessageText sendFinishedMessageUz(Long chatId, Integer messageId) {
        return SendMsg.sendMsgEditeParseMode("*Bizni tanlaganingizdan minnatdormiz ! \n" +
                "Tez orada siz bilan bog'lanamiz. Siz bilan Pharma Cosmos HR roboti bo'ldi* \uD83E\uDD16 !", chatId, messageId);
    }


    public static EditMessageText getLanguage_uz(Long chatId, Integer messageId) {
        return SendMsg.sendMsgEditeButton("*Rus tilini bilish darajangizni tanlang* \uD83D\uDC47", chatId, messageId,
                InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("A'lo darajada", ButtonName.perfect_uz)),
                        InlineButton.row(InlineButton.button("Yaxshi", ButtonName.good_uz)),
                        InlineButton.row(InlineButton.button("Bilmayman", ButtonName.dont_uz))

                )));
    }
}
