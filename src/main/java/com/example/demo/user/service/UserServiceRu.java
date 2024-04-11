package com.example.demo.user.service;


import com.example.demo.user.button.InlineButton;
import com.example.demo.user.message.SendMsg;
import com.example.demo.user.util.ButtonName;
import com.example.demo.user.util.Profile;
import com.example.demo.user.util.SmsUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;


public class UserServiceRu {
    public static EditMessageText getUserNameRu(Long chatId, Integer messageId) {
        return SendMsg.sendMsgEditeParseMode("Ввидите свои имя и фамилию \n" +
                        "*Например : Амонов Фирдавс*",
                chatId, messageId);
    }

    public static SendMessage getPhoneNumberRu(Long chatId, Integer messageId) {
        return SendMsg.sendMsgParseMode("Пожалуйста, введите свой номер телефона в порядке ниже!" +
                "\n*Например : +998900279803*", chatId);

    }

    public static EditMessageText getExperience(Long chatId, Integer messageId) {

        return SendMsg.sendMsgEditeButton("*Пожалуйста, выберите стаж работы* \uD83D\uDC47 ",
                chatId, messageId, InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("0 - 1 год", ButtonName.one_year_ru)),
                        InlineButton.row(InlineButton.button("1 - 3 год", ButtonName.two_year_ru)),
                        InlineButton.row(InlineButton.button("3 - 5 год", ButtonName.three_year_ru)),
                        InlineButton.row(InlineButton.button("5 лет и выше", ButtonName.five_year_ru)))));
    }

    public static SendMessage getDataRu(Long chatId) {
        return SendMsg.sendMsgInlineButton("*Пожалуйста, выберите вашу образование* \uD83D\uDC47 ", chatId,
                InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("Высшее образование", ButtonName.institute_ru)),
                        InlineButton.row(InlineButton.button("Средний специальный", ButtonName.colledge_ru)),
                        InlineButton.row(InlineButton.button("Cтудент", ButtonName.unfinished_ru)))));

    }

    public static EditMessageText getProfessionRu(Long chatId, Integer messageId) {
        return SendMsg.sendMsgEditeButton("*Пожалуйста, выберите вакансию* \uD83D\uDC47", chatId, messageId,
                InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("заведующий", ButtonName.menejer_ru)),
                        InlineButton.row(InlineButton.button("Фармацевт", ButtonName.pharma_ru)),
                        InlineButton.row(InlineButton.button("стажер-практикант", ButtonName.practician_ru))
                )));

    }

    public static EditMessageText sendFinishedMessageRu(Long chatId, Integer messageId) {
        return SendMsg.sendMsgEditeParseMode("*Спасибо, что выбрали нас!* \n" +
                "*Мы свяжемся с вами в ближайшее время. Робот Pharma Cosmos HR с вами *\uD83E\uDD16 !", chatId, messageId);
    }

    public static EditMessageText claimMessageRU(Profile profile, Long chatId, Integer messageId) {
        return SendMsg.sendMsgEditeButton("\t\t\t\t*Пожалуйста, подтвердите транзакцию *\uD83D\uDC47 " +
                        "\n\n\n*Имя и фамилия :* " + profile.getFullName() + "" +
                        "\n\n*Номер телефона :* " + profile.getPhone() + "" +
                        "\n\n*Информация:* " + profile.getData() + "" +
                        "\n\n*профессия : *" + profile.getProfession() +
                        "\n\n*опыт : *" + profile.getExp() +
                        "\n\n*русский язык : *" + profile.getLanguage(),

                chatId, messageId,
                InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("Подтверждение", "claim_ru")))));
    }

    public static void sendSmsToAdminRu(Profile profile) {
        SmsUtil.sendSmsCode("+998900279803",
                "\n\nИмя :" + profile.getFullName() +
                        "\n\nНомер телефона : " + profile.getPhone() +
                        "\n\nИнформация: " + profile.getData() +
                        "\n\nпрофессия : " + profile.getProfession() +
                        "\n\nопыт : " + profile.getExp() +
                        "\n\nрусский язык : " + profile.getLanguage());
    }

    public static SendMessage sendToAdminRu(Profile profile, Long chatId) {
        return SendMsg.sendMsgParseMode(
                "*\t\t\t\tВакансия Сотрудник*" +
                        "\n\n*Имя :* " + profile.getFullName() +
                        "\n\n*Номер телефона :* " + profile.getPhone() +
                        "\n\n*Информация : *" + profile.getData() +
                        "\n\n*профессия :* " + profile.getProfession() +
                        "\n\n*опыт :* " + profile.getExp()
                        + "\n\n*русский язык : *" + profile.getLanguage(), chatId
        );
    }

    public static EditMessageText getLanguage_ru(Long chatId, Integer messageId) {
        return SendMsg.sendMsgEditeButton("*Выберите свой уровень владения русским языком* \uD83D\uDC47", chatId, messageId,
                InlineButton.keyboardMarkup(InlineButton.rowList(
                        InlineButton.row(InlineButton.button("Мой родной язык", ButtonName.perfect_ru)),
                        InlineButton.row(InlineButton.button("Хорошо", ButtonName.good_ru)),
                        InlineButton.row(InlineButton.button("Я не знаю", ButtonName.dont_ru))

                )));
    }
}
