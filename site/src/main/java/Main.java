import auth.Account;
import auth.AccountManager;
import database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.connect("baza_auth.db");

        AccountManager accountManager = new AccountManager(dbConnection);

        accountManager.register("testUser", "mojeTajneHaslo");

        System.out.println("Logowanie dobrym hasłem: " + accountManager.authenticate("testUser", "mojeTajneHaslo"));
        System.out.println("Logowanie złym hasłem: " + accountManager.authenticate("testUser", "zle123"));

        Account acc = accountManager.getAccount("testUser");
        if (acc != null) {
            System.out.println("Znaleziono konto: " + acc);
            System.out.println("Szukanie po ID (" + acc.id() + "): " + accountManager.getAccount(acc.id()));
        }

        dbConnection.disconnect();
    }
}