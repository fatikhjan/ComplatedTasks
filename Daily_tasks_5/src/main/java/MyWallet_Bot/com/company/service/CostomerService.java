package MyWallet_Bot.com.company.service;

import MyWallet_Bot.com.company.db.DataBase;
import MyWallet_Bot.com.company.entity.Costomer;

public class CostomerService {
    public static Costomer getcostumerByChatId(String chatId) {
    return DataBase.costumersList.stream().
            filter(costomer -> costomer.getChatId().equals(chatId)).
            findFirst().orElse(null);
    }
}
