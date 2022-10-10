package ru.job4j;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * @param user - это объект класса User
     */
    public void addUser(User user) {
        List<Account> userList = new ArrayList<>();
        users.putIfAbsent(user, userList);
    }

    /**
     * Метод добавляющий счет пользователю
     * @param passport - переменная по которой метод ищет пользователя
     * @param account - переменная которая содержит счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userList = users.get(user);
            if (!userList.contains(account)) {
                userList.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по полю passport
     * @param passport - серия, номер паспорта
     * @return результат поиска
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод поиска по реквизитам
     * @param passport - серия, номер паспорта
     * @param requisite - реквизиты счета
     * @return результат поиска
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод транзакций денежных средств
     * @param srcPassport - серия, номер паспорта, переводящего пользователя
     * @param srcRequisite - реквизиты, переводящего пользователя
     * @param destPassport - серия, номер паспорта, получающего пользователя
     * @param destRequisite - реквизиты, получающего пользователя
     * @param amount - количество денежных средств
     * @return результат перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        boolean rsl = false;
        if (srcAcc != null && destAcc != null
                && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
