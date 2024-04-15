package com.example.demo.user.controller;

import com.example.demo.user.enums.Step;
import com.example.demo.user.main.MyTelegramBot;
import com.example.demo.user.service.TelegramMessageService;
import com.example.demo.user.service.UserServiceRu;
import com.example.demo.user.service.UserServiceUzb;
import com.example.demo.user.util.CheckMessage;
import com.example.demo.user.util.Profile;
import com.example.demo.user.util.TelegramUser;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller

public class MainController {
    private final MyTelegramBot myTelegramBot;
    private final List<TelegramUser> usersList = new ArrayList<>();
    public final Profile profile = new Profile();

    public MainController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
    }//


    public void handle(Message message, String lan) {

        TelegramUser step = saveUser(message.getChatId());
        if (step.getStep() == null || message.getText().equals("/start" )) {
            myTelegramBot.sendMessage(TelegramMessageService.selectLanguage(message.getChatId()));
            step.setStep(Step.NONE);
            return;
        }

        if (lan.equals("cancel_uz")){
            myTelegramBot.sendEditeMessage(UserServiceUzb.sendCancelInfoUz(message.getChatId(),message.getMessageId()));
            step.setStep(Step.NONE);
            return;
        }

        if (lan.equals("cancel_ru")){
            myTelegramBot.sendEditeMessage(UserServiceRu.sendCancelInfoRu(message.getChatId(),message.getMessageId()));
            step.setStep(Step.NONE);
            return;
        }

        if (lan.equals("uz")) step.setStep(Step.MAIN_UZ);
        if (lan.equals("ru")) step.setStep(Step.MAIN_RU);



        if (Objects.requireNonNull(step.getStep()) == Step.MAIN_UZ) {

            myTelegramBot.sendEditeMessage(UserServiceUzb.getUserNameUz(message.getChatId(), message.getMessageId()));
            step.setStep(Step.GET_NAME_UZ);
            return;

        } else if (step.getStep() == Step.GET_NAME_UZ) {

            profile.setFullName(message.getText());
            myTelegramBot.sendMessage(UserServiceUzb.getPhoneNumberUz(message.getChatId(), message.getMessageId()));
            step.setStep(Step.GET_PHONE_UZ);
            return;

        } else if (step.getStep() == Step.GET_PHONE_UZ) {

            if (CheckMessage.checkPhone(message.getText())) {

                myTelegramBot.sendMessage(UserServiceUzb.getPhoneNumberUz(message.getChatId(), message.getMessageId()));

            } else {

                profile.setPhone(message.getText());
                myTelegramBot.sendMessage(UserServiceUzb.getDataUz(message.getChatId()));
                step.setStep(Step.GET_DATA_UZ);
            }

        } else if (step.getStep() == Step.GET_DATA_UZ) {

            profile.setData(lan);
            myTelegramBot.sendEditeMessage(UserServiceUzb.getProfessionUz(message.getChatId(), message.getMessageId()));
            step.setStep(Step.GET_PROFESSION_UZ);
            return;

        } else if (step.getStep() == Step.GET_PROFESSION_UZ) {

            profile.setProfession(lan);
            myTelegramBot.sendEditeMessage(UserServiceUzb.getExperience(message.getChatId(), message.getMessageId()));
            step.setStep(Step.EXP_UZ);
            return;

        } else if (step.getStep() == Step.EXP_UZ) {

            profile.setExp(lan);
            myTelegramBot.sendEditeMessage(UserServiceUzb.getLanguage_uz(message.getChatId(), message.getMessageId()));
            step.setStep(Step.GET_LAN_UZ);

        } else if (step.getStep() == Step.GET_LAN_UZ) {

            profile.setLanguage(lan);
            myTelegramBot.sendEditeMessage(UserServiceUzb.claimMessageUz(profile, message.getChatId(), message.getMessageId()));
            step.setStep(Step.CLAIM_UZ);

        } else if (step.getStep() == Step.CLAIM_UZ) {
               myTelegramBot.sendEditeMessage(UserServiceUzb.sendFinishedMessageUz(message.getChatId(), message.getMessageId()));
               myTelegramBot.sendMessage(UserServiceUzb.sendToAdmin(profile, 6846515723L));
               myTelegramBot.sendMessage(UserServiceUzb.sendToAdmin(profile, 38238435L));
               myTelegramBot.sendMessage(UserServiceUzb.sendToAdmin(profile, 7138810801L));
               //UserServiceUzb.sendSmsToAdmin1(profile);
              // UserServiceUzb.sendSmsToAdmin2(profile);
            step.setStep(Step.NONE);
            return;

        }


        if (step.getStep() == Step.MAIN_RU) {

            myTelegramBot.sendEditeMessage(UserServiceRu.getUserNameRu(message.getChatId(), message.getMessageId()));
            step.setStep(Step.GET_NAME_RU);

        } else if (step.getStep() == Step.GET_NAME_RU) {

            profile.setFullName(message.getText());
            myTelegramBot.sendMessage(UserServiceRu.getPhoneNumberRu(message.getChatId(), message.getMessageId()));
            step.setStep(Step.GET_PHONE_RU);

        } else if (step.getStep() == Step.GET_PHONE_RU) {

            if (CheckMessage.checkPhone(message.getText())) {
                myTelegramBot.sendMessage(UserServiceRu.getPhoneNumberRu(message.getChatId(), message.getMessageId()));
            } else {
                profile.setPhone(message.getText());
                myTelegramBot.sendMessage(UserServiceRu.getDataRu(message.getChatId()));
                step.setStep(Step.GET_DATA_RU);
            }


        } else if (step.getStep() == Step.GET_DATA_RU) {

            profile.setData(lan);
            myTelegramBot.sendEditeMessage(UserServiceRu.getProfessionRu(message.getChatId(), message.getMessageId()));
            step.setStep(Step.GET_PROFESSION_RU);

        } else if (step.getStep() == Step.GET_PROFESSION_RU) {

            profile.setProfession(lan);
            myTelegramBot.sendEditeMessage(UserServiceRu.getExperience(message.getChatId(), message.getMessageId()));
            step.setStep(Step.EXP_RU);

        } else if (step.getStep() == Step.EXP_RU) {

            profile.setExp(lan);
            myTelegramBot.sendEditeMessage(UserServiceRu.getLanguage_ru(message.getChatId(), message.getMessageId()));
            step.setStep(Step.GET_LAN_RU);

        } else if (step.getStep() == Step.GET_LAN_RU) {
            profile.setLanguage(lan);
            myTelegramBot.sendEditeMessage(UserServiceRu.claimMessageRU(profile, message.getChatId(), message.getMessageId()));
            step.setStep(Step.CLAIM_RU);

        } else if (step.getStep() == Step.CLAIM_RU) {
            myTelegramBot.sendEditeMessage(UserServiceRu.sendFinishedMessageRu(message.getChatId(), message.getMessageId()));
            myTelegramBot.sendMessage(UserServiceRu.sendToAdminRu(profile, 6846515723L));
             myTelegramBot.sendMessage(UserServiceUzb.sendToAdmin(profile, 38238435L));
            myTelegramBot.sendMessage(UserServiceUzb.sendToAdmin(profile, 7138810801L));
             //UserServiceRu.sendSmsToAdminRu1(profile);
            // UserServiceRu.sendSmsToAdminRu2(profile);
            step.setStep(Step.NONE);

        }
    }


    public TelegramUser saveUser(Long chatId) {
        TelegramUser user = usersList.stream().filter(u -> u.getChatId().equals(chatId)).findAny().orElse(null);
        if (user != null) return user;
        TelegramUser users = new TelegramUser();
        users.setChatId(chatId);
        usersList.add(users);
        return users;
    }//
}
