package com.company.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class Messege_Sender {
    static  String Accaunt_Sid = "AC29c635e5c4378f86eba8c12be75eed04";
    static String Auth_Token = "e3306974862016c76e0c55df992e3dda";

    public static void main(String[] args) {
        Twilio.init(Accaunt_Sid,Auth_Token);

        Message.creator(
                new PhoneNumber("+998977523052"),
                new PhoneNumber("+18336102044"),
                "nima gapeee"
        ).create();
    }
}
