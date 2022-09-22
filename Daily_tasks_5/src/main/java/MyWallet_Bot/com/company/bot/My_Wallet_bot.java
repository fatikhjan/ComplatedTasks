package MyWallet_Bot.com.company.bot;

import MyWallet_Bot.com.company.controller.MainController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class My_Wallet_bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "t.me/Hoztavar_bot";
    }
    @Override
    public String getBotToken() {
        return "5729773832:AAGdj0YQc9lV9DKy8kLV1AvXxTHTZUHO1Ok";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message=  update.getMessage();
            User user = update.getMessage().getFrom();

            MainController.handleMessege(message,user);
        }else if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery= update.getCallbackQuery();
        }
    }


    public void sendMsg(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
