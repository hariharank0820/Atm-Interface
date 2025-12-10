import java.util.Scanner;

public class Banking {
   static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1.Transaction History");
        System.out.println("2.Withdraw");
        System.out.println("3.Deposit");
        System.out.println("4.Transfer");
        System.out.println("5.Quit");
    }
    static double withdraw(double balance){
        double amount;
        System.out.println("Enter Your Withdrawal amount: ");
        amount = sc.nextDouble();
        if(amount > balance){
            System.out.println("Insufficient Balance!");
            return 0;
        }else if(amount < 0){
            System.out.println("Amount cant be in Negative");
            return 0;
        }else{
            return amount;
        }
    }
    static double deposit(){
        double amt;
        System.out.print("Enter a Amount to Deposit: ");
        amt = sc.nextDouble();
        if(amt < 0){
            System.out.println("Amount cant be in Negative");
            return 0;
        }else{
            return amt;
        }
    }



}
