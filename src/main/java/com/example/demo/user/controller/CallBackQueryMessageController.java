package com.example.demo.user.controller;

import com.example.demo.user.util.ButtonName;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

@Controller
public class CallBackQueryMessageController {

    private final MainController controller;

    public CallBackQueryMessageController(MainController controller) {
        this.controller = controller;
    }

    public void callBackMessage(CallbackQuery callbackQuery) {
        Message message = callbackQuery.getMessage();
        String data = callbackQuery.getData();
        switch (data) {
            case ButtonName.lan_uz -> controller.handle(message, "uz");
            case ButtonName.lan_ru -> controller.handle(message, "ru");
            case ButtonName.institute_uz -> controller.handle(message, ButtonName.institute_uz);
            case ButtonName.institute_ru -> controller.handle(message, ButtonName.institute_ru);
            case ButtonName.colledge_uz -> controller.handle(message, ButtonName.colledge_uz);
            case ButtonName.colledge_ru -> controller.handle(message, ButtonName.colledge_ru);
            case ButtonName.unfinished_uz -> controller.handle(message, ButtonName.unfinished_uz);
            case ButtonName.unfinished_ru -> controller.handle(message, ButtonName.unfinished_ru);
            case ButtonName.menejer_uz -> controller.handle(message, ButtonName.menejer_uz);
            case ButtonName.menejer_ru -> controller.handle(message, ButtonName.menejer_ru);
            case ButtonName.pharma_uz -> controller.handle(message, ButtonName.pharma_uz);
            case ButtonName.pharma_ru -> controller.handle(message, ButtonName.pharma_ru);
            case ButtonName.practician_uz -> controller.handle(message, ButtonName.practician_uz);
            case ButtonName.practician_ru -> controller.handle(message, ButtonName.practician_ru);
            case ButtonName.one_year_uz -> controller.handle(message, ButtonName.one_year_uz);
            case ButtonName.one_year_ru -> controller.handle(message, ButtonName.one_year_ru);
            case ButtonName.two_year_uz -> controller.handle(message, ButtonName.two_year_uz);
            case ButtonName.two_year_ru -> controller.handle(message, ButtonName.two_year_ru);
            case ButtonName.three_year_uz -> controller.handle(message, ButtonName.three_year_uz);
            case ButtonName.three_year_ru -> controller.handle(message, ButtonName.three_year_ru);
            case ButtonName.five_year_uz -> controller.handle(message, ButtonName.five_year_uz);
            case ButtonName.five_year_ru -> controller.handle(message, ButtonName.five_year_ru);
            case ButtonName.perfect_uz -> controller.handle(message, ButtonName.perfect_uz);
            case ButtonName.perfect_ru -> controller.handle(message, ButtonName.perfect_ru);
            case ButtonName.good_uz -> controller.handle(message, ButtonName.good_uz);
            case ButtonName.good_ru -> controller.handle(message, ButtonName.good_ru);
            case ButtonName.dont_uz -> controller.handle(message, ButtonName.dont_uz);
            case ButtonName.dont_ru -> controller.handle(message, ButtonName.dont_ru);
            case ButtonName.dostavchik_uz -> controller.handle(message, ButtonName.dostavchik_uz);
            case ButtonName.dostavchik_ru -> controller.handle(message, ButtonName.dostavchik_ru);
            case ButtonName.prodaja_uz -> controller.handle(message,ButtonName.prodaja_uz);
            case ButtonName.prodaja_ru -> controller.handle(message,ButtonName.prodaja_ru);
            case ButtonName.sklad_uz -> controller.handle(message,ButtonName.sklad_uz);
            case ButtonName.sklad_ru -> controller.handle(message,ButtonName.sklad_ru);
            case "claim_uz", "claim_ru" -> controller.handle(message, "");

        }
    }


}
