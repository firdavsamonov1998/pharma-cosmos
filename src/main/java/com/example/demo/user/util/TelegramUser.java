package com.example.demo.user.util;


import com.example.demo.user.enums.Step;

public class TelegramUser {
    private Long chatId;
    private Step step;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }



}
