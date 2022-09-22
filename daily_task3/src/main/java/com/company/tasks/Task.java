package com.company.tasks;

import com.company.entity.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task {
    public static List<User> userList = new ArrayList<>();
    public static Scanner text = new Scanner(System.in);
    public static Scanner number = new Scanner(System.in);
    public static String UserNumber = null;

    static String Accaunt_Sid = "AC29c635e5c4378f86eba8c12be75eed04";
    static String Auth_Token = "e3306974862016c76e0c55df992e3dda";

    public static String sendedCode = null;

    public static void main(String[] args) {
        System.out.println("Hush kelibsiz");
        while (true) {
            System.out.println("1=> registr");
            System.out.println("2=> see users");
            System.out.println("3=> Exit");
            int menu = number.nextInt();
            switch (menu) {
                case 1:
                    registration();
                    break;
                case 2:
                    for (int i = 0; i < userList.size(); i++) {
                        System.out.println(userList.get(i));
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("someThing was Wrong");
            }
        }
    }

    private static void registration() {
        int popitka = 0;
        System.out.println("Enter your name");
        String name = text.nextLine();
        System.out.println("Enter your Phone NUmber");
        String number1 = text.nextLine();
        UserNumber =number1;
        System.out.println("wait a minut");
        String code = generateCode();
        sendedCode = code;
        boolean isCodeSended = sendCode(code);
        if (isCodeSended) {
            while (popitka < 3) {
                System.out.println("We have Sended 6 formatted code ");
                int insertedCode = number.nextInt();
                if (code.equals(String.valueOf(insertedCode))) {
                    userList.add(new User(name, number1, String.valueOf(insertedCode), false));
                    MenuPanel();
                    return;
                } else {
                    popitka++;
                }
            }
            if (popitka == 3) {
                userList.add(new User(name, number1, null, false));
                System.out.println("You are bloced Becouse of you have enterd more codes");
                sendedCode = null;
                return;
            }
        } else System.out.println("your number is wrong");
    }

    private static void MenuPanel() {
        System.out.println("You have Succsessfully registered");
        return;
    }

    private static boolean sendCode(String code) {

        Twilio.init(Accaunt_Sid, Auth_Token);
        try {
            Message.creator(
                    new PhoneNumber(UserNumber),
                    new PhoneNumber("+18336102044"),
                    "your Approvial Code : " + code
            ).create();
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    private static String generateCode() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
