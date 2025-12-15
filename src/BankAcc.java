import java.util.Scanner;

public class BankAcc {
  String name;
  String UserName;
  String pass;
  long AccountNO;
  float balance = 80000f;
  int transaction = 0;
  String transactionHistory = "";

  public void register(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter Your Name: ");
      this.name= in.nextLine();
      System.out.print("Enter Your UserName: ");
      this.UserName=in.nextLine();
      System.out.print("Enter Your Password: ");
      this.pass=in.nextLine();
      System.out.print("Enter Your Account Number: ");
      this.AccountNO=in.nextInt();
      System.out.print("Registration Successfully Completed.");
      System.out.println("Login To Your Bank Account.");
  }
  public boolean login(){
      boolean isLogin=false;
      Scanner in = new Scanner(System.in);
      while(!isLogin){
          System.out.print("Enter Your UserName: ");
          String Username=in.nextLine();
          if(Username.equals(UserName)){
              while(!isLogin){
                  System.out.print("Enter Your Password: ");
                  String passWord=in.nextLine();
                  if(passWord.equals(pass)){
                      System.out.println("\nLogin Successful!");
                      isLogin = true;

                  }else{
                      System.out.println("Incorrect Password");
                  }
              }
          }else{
              System.out.println("UserName Not found");
          }
      }
      return isLogin;
  }
  public void withdraw(){
      System.out.print("Enter Your Withdraw Amount: ");
      Scanner in = new Scanner(System.in);
      float amt = in.nextFloat();
      try{
          if(balance >= amt){
              transaction++;
              balance-=amt;
              System.out.println("Withdral Successful.");
              String string ="₹."+ amt +" Withdrawn\n";
              transactionHistory = transactionHistory.concat(string);
          }else{
              System.out.println("\nInsufficient Balance.");
          }
      }
      catch(Exception e){

      }
  }
  public void deposit(){
      System.out.print("Enter the Amount to Deposit: ");
      Scanner in = new Scanner(System.in);
      float amt = in.nextFloat();
      try{
          if(amt <= balance){
              transaction++;
              balance+=amt;
              System.out.println("Deposit Successful.");
              String string = "₹."+amt+ " deposited";
              transactionHistory = transactionHistory.concat(string);
          }else{
              System.out.println("There is only limited deposit amount!");
          }
      }catch(Exception e){

      }
  }
  public void transfer(){
      Scanner in = new Scanner(System.in);
      System.out.print("Enter Receipent Name: ");
      String receipent = in.nextLine();
      System.out.print("Enter a Amount to Transfer: ");
      float amt = in.nextFloat();
      try{
          if(balance >= amt){
              if(amt <= 100000){
                  transaction++;
                  balance-=amt;
                  System.out.println("Amount Successfully Transferred to "+ receipent);
                  String string = "\n₹."+amt + " Transferred to "+ receipent;
                  transactionHistory = transactionHistory.concat(string);
              }else{
                  System.out.println("The Limit is 100000.");
              }
          }else{
              System.out.println("Insufficient Balance!");
          }
      }catch(Exception e){

      }
  }
  public void tranxHistory(){
      if(transaction==0){
          System.out.println("There is not Transaction happened!");
      }else{
          System.out.println("\n "+transactionHistory);
      }
  }
  public void checkBalance(){
      System.out.println("\n₹."+balance);
  }
  public class ATM{
      public static int takenIntegerInput(int limit){
          int input=0;
          boolean flag = false;
          while(!flag){
              try{
                  Scanner in = new Scanner(System.in);
                  input = in.nextInt();
                  flag = true;
                  if(flag && input>limit || input<1){
                      System.out.println("Choose the any number between 1 to "+limit);
                      flag=false;
                  }
              }catch(Exception e){
                  System.out.println("Enter the values in Integer. ");
                  flag=false;
              }
          }return input;
      }
  }
    public static void main(String[] args) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("*************WELCOME TO ATM INTERFACE*************");
        System.out.println("--------------------------------------------------");
        System.out.println("\n1.Register \n2.Exit");
        System.out.print("Choose Any One Option: ");
        int choose = ATM.takenIntegerInput(2);
        if(choose==2){
            System.out.println("Thank You! Have a Wonderful Day.");
            System.exit(0);
        }
        if(choose==1){
            BankAcc b = new BankAcc();
            b.register();
            while(true){
                System.out.println("\n1.Login  \n2.Exit");
                System.out.print("Enter Your Choice: ");
                int ch = ATM.takenIntegerInput(2);
                if(ch==2){
                    System.out.println("Have A Wonderful Day!");
                    System.exit(0);
                }
                if(ch==1 && b.login()){
                    System.out.println("--------------------------------------------------");
                    System.out.println("           ***********WELCOME***********");
                    System.out.println("--------------------------------------------------");
                    boolean isFinished = false;
                    while(!isFinished){
                        System.out.println("\n1.Withdraw");
                        System.out.println("2.Deposit");
                        System.out.println("3.Transfer");
                        System.out.println("4.Check Bank Balance");
                        System.out.println("5.Transaction History");
                        System.out.println("6.Exit");
                        System.out.print("Enter Your Choice: ");
                        int c = ATM.takenIntegerInput(6);
                        switch(c){
                            case 1:
                                b.withdraw();
                                break;
                            case 2:
                                b.deposit();
                                break;
                            case 3:
                                b.transfer();
                                break;
                            case 4:
                                b.checkBalance();
                                break;
                            case 5:
                                b.tranxHistory();
                                break;
                            case 6:
                                isFinished=true;
                                System.out.println("Logged out Successfully!");
                                break;
                        }
                    }
                }else{
                    System.out.println("\nHave a Wonderful Day!");
                    System.exit(0);
                }
            }
        }
    }
  }
