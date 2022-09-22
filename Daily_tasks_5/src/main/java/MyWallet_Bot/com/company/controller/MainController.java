package MyWallet_Bot.com.company.controller;

import MyWallet_Bot.com.company.contenir.ComponentContainer;
import MyWallet_Bot.com.company.entity.Costomer;
import MyWallet_Bot.com.company.service.CostomerService;
import MyWallet_Bot.com.company.util.KeyboardButtonUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;


public class MainController {
    public static void handleMessege(Message message, User user) {
        String chatID = String.valueOf(message.getChatId());

        if (message.hasText()) {
            String text = message.getText();
            textHandler(user, message, text);
        } else if (message.hasContact()) {
            Contact contact = message.getContact();
            contacthandler(message, contact, user);
        } else if (message.hasLocation()) {
            Location location = message.getLocation();
            locationHandler(message, user, location);
        } else if (message.hasDocument()) {
            Document doc = message.getDocument();
            docHandler(message, user, doc);
        }
    }

    private static void docHandler(Message message, User user, Document doc) {
    }

    private static void locationHandler(Message message, User user, Location location) {
    }

    private static void contacthandler(Message message, Contact contact, User user) {
    }

    private static void textHandler(User user, Message message, String text) {
        String chatId = String.valueOf(message.getChatId());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        if (text.equals("/start")) {

            Costomer costomer = CostomerService.getcostumerByChatId(chatId);

            if (costomer == null) {
                sendMessage.setText("Hello!\n Send your Phone Number");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.getContactMenu());
            } else {
              sendMessage.setText("Hello Welcome");
              sendMessage.setReplyMarkup(KeyboardButtonUtil.getBaseMenu( ));
            }

        }

        ComponentContainer.MY_BOT.sendMsg(sendMessage);
    }
}
