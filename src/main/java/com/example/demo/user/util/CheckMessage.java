package com.example.demo.user.util;

public class CheckMessage {
    public static boolean checkPhone(String phone) {
        if (!phone.startsWith("+998") || phone.length() != 13) return true;
        for (int i = 1; i < phone.length(); i++) if (!Character.isDigit(phone.charAt(i))) return true;
        return false;
    }

}
