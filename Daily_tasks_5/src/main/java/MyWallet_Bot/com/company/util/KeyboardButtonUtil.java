package MyWallet_Bot.com.company.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.awt.*;
import java.util.List;

public class KeyboardButtonUtil {

    public static ReplyKeyboard getContactMenu() {
        KeyboardButton button = new KeyboardButton("Send Phone Number");
        button.setRequestContact(true);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(List.of(
                new KeyboardRow(List.of(button))
        ));
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        return markup;
    }

    public static ReplyKeyboard getBaseMenu() {
//        KeyboardButton button = new KeyboardButton();
//        List<KeyboardRow> rowList = List.of(row1, row2, row3,
//                new KeyboardRow(List.of(new KeyboardButton(INLINES_DEMO))));
//
//        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(rowList);
//
////        markup.setOneTimeKeyboard(true);
//        markup.setSelective(true);
//        markup.setResizeKeyboard(true);
//
//        return markup;
        return null;
    }
}
