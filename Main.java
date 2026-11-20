import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
       Scanner scan=new Scanner(System.in);
        int PIN;
        int attempts=0;
        double balance=2500.75;
        boolean login = false;
        int choice;
        int transactions = 0;
        while (attempts<3)
       {
           System.out.println("Enter The PIN:");
           PIN=scan.nextInt();
           if (PIN==1234)
           {
               login=true;
               break;
           }
           else
           {
               attempts++;
               System.out.println("Wrong password");
           }
       }
        if (login == false) {
            System.out.println("Your account has been locked.");
        }
        else {
            do {
                System.out.println("========= ATM =========");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Show Account Status");
                System.out.println("5. Exit");
                System.out.println("=======================");

                choice = scan.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("your current balance:" + balance);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter deposit amount:");
                        double deposit = scan.nextDouble();
                        if (deposit <= 0)
                            System.out.println("Invalid amount.");
                        else {
                            balance += deposit;
                            System.out.println("Your balance after deposit:" + balance);
                            transactions++;
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Enter withdrawal amount:");
                        double withdraw = scan.nextDouble();
                        if (withdraw < 0)
                            System.out.println("Invalid amount.");
                        else if (withdraw > balance)
                            System.out.println("Insufficient balance.");
                        else if (withdraw == 0)
                            System.out.println("Transaction cancelled.");
                        else {
                            balance -= withdraw;
                            System.out.println("Your balance after withdrawal:" + balance);
                            transactions++;
                            if (balance == 0)
                                System.out.println("Warning: Your account is empty.");
                        }
                        break;
                    }
                    case 4: {
                        if (balance >= 5000)
                            System.out.println("VIP Customer");
                        else if (balance >= 1000 && balance < 5000)
                            System.out.println("Regular Customer");
                        else
                            System.out.println("Low Balance");
                        break;
                    }
                    case 5: {
                        System.out.println("Thank you for using our ATM.");
                        System.out.println("Total successful transactions:" + transactions);
                        break;
                    }
                    default: {
                        System.out.println("Invalid option.");
                    }
                }

            } while (choice != 5);
        }
    }
}
