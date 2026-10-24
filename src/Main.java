import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Сумма снятия должна быть больше нуля!"
            );
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Недостаточно средств на счёте!"
            );
        }

        balance -= amount;
        System.out.println("Операция выполнена успешно!");
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BankAccount account = new BankAccount(1000);

        System.out.println("Баланс: " + account.getBalance());
        System.out.print("Введите сумму снятия: ");

        double amount = scan.nextDouble();

        try {
            account.withdraw(amount);
            System.out.println("Остаток на счёте: "
                    + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scan.close();
    }
}
