/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.

 Account models a bank account
 TODO make 7 mods
 1. Modifying Withdrawal Behavior - done
 2. Merging Accounts - done
 3. Overdraft Protection - done

 */


public class Account {
    public int balance;
    public Account parentAccount;

    /** Initialize an account with the given BALANCE. */
    public Account(int balance) {
        this.balance = balance;
        this.parentAccount = null;
    }
    /** Initialize an account with the given BALANCE and parent reference */
    public Account(int balance, Account parent) {
      this.balance = balance;
      this.parentAccount = parent;
    }

    /** Deposits AMOUNT into the current account. */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract AMOUNT from the account if possible. If subtracting AMOUNT
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
      // Named the cond expr used to improve readbility
        boolean amountIsInvalid = amount < 0;
        boolean accountInsufficientFunds = balance < amount;
        boolean parentAccountExist = this.parentAccount != null;

        if (amountIsInvalid) {
            System.out.println("Fatal: Cannot withdraw negative amount.");
            return false;
        }
        else if (accountInsufficientFunds) {
          // error handling:Need to have print statement to let the
          //user know whats going on

          // this logic can be given a name
            System.out.println("InsufficientFunds: Will attempt to withdraw from parent account");
            if (parentAccountExist) {
              int newAmount = amount - this.balance;

              // status is not a descriptive name
              // verb for a boolean variable is more desriptive
              // withdrawSuccessful == true || false
              boolean withdrawSuccessful =  this.parentAccount.withdraw(newAmount);

              if (withdrawSuccessful) {
                System.out.println("Funds successfuly withdrawn from parent account");
                // update instanceBalance
                this.balance = 0;
              }
              System.out.println("Warning: parent account InsufficientFunds");
              return withdrawSuccessful;
            }
            return false;
        }
        else {
            balance -= amount;
            System.out.println("Balance: $" + balance);
            return true;
        }
    }

    /**
     * Merge account OTHER into this account by removing all money from OTHER
     * and depositing it into this account.
     Should transfer all of the money from the argument account to the current account.
    arg account balance should be zeroed
    current account’s balance increases by the argument’s old balance.
     */
    public void merge(Account other) {
        int moneyToTransfer = this.balance;
        this.balance = 0;

        // transfer balance
        other.balance += moneyToTransfer;
        System.out.println("Success: $" + moneyToTransfer + " transfered");
        System.out.println("The new balance of the Account other is $" + other.balance);

    }

    // public void merge2(Account other) {
    //   // instance method
    //   // takes in a Account obj other
    //
    //   // add your balance to my balance
    //   // my balance = my balance + your balance
    //   this.balance = this.balance + other.balance;
    //
    //   // declare a ref obect other
    //   // new keyword instantiates a new instance of account and assigns
    //   // Account instance variables to null or 0
    //   // Account constructor binds the input arg 0 to the formal paramter balance
    //   other = new Account(0);
    //
    //   // the reference var other, which contains the address of the instance passed in, is lost.
    //   // other is updated to point to a new instance that was created
    //
    //   // this does not set the input instance that balance was merged to 0
    //   // it sets a newly created instance balance to 0, which is not what is expected
    //   // of this functino
    // }



}
