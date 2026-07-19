import java.util.Scanner;

// बँक खात्याचा क्लास
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("रु. " + amount + " यशस्वीरित्या जमा झाले.");
        } else {
            System.out.println("कृपया वैध रक्कम टाका.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("रु. " + amount + " यशस्वीरित्या काढले गेले.");
            return true;
        } else if (amount > balance) {
            System.out.println("खात्यात अपुरी शिल्लक आहे!");
            return false;
        } else {
            System.out.println("कृपया वैध रक्कम टाका.");
            return false;
        }
    }
}

// एटीएम मशीनचा मुख्य क्लास
public class AtmInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // सुरुवातीची शिल्लक रु. ५००० ठेवली आहे
        BankAccount account = new BankAccount(5000.0); 

        System.out.println("--- ATM मशीन मध्ये तुमचे स्वागत आहे ---");
        boolean exit = false;

        while (!exit) {
            System.out.println("\n१. शिल्लक तपासा (Check Balance)");
            System.out.println("२. पैसे भरा (Deposit)");
            System.out.println("३. पैसे काढा (Withdraw)");
            System.out.println("४. बाहेर पडा (Exit)");
            System.out.print("तुमचा पर्याय निवडा (१-४): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("तुमची सध्याची शिल्लक: रु. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("जमा करायची रक्कम टाका: ");
                    double depAmount = sc.nextDouble();
                    account.deposit(depAmount);
                    break;
                case 3:
                    System.out.print("काढायची रक्कम टाका: ");
                    double withAmount = sc.nextDouble();
                    account.withdraw(withAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("एटीएम वापरल्याबद्दल धन्यवाद. तुमचा दिवस चांगला जावो!");
                    break;
                default:
                    System.out.println("अवैध पर्याय! कृपया १ ते ४ मधील नंबर निवडा.");
            }
        }
        sc.close();
    }
}
