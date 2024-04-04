public class Accounts{
    private int _accountNumber;
    private int _accountBalance;
  
    public Accounts (int accountNumber, int accountBalance) {
      _accountNumber = accountNumber;
      _accountBalance = accountBalance;
    }
    
    public void set_accountNumber (int accountNumber) {
        _accountNumber = accountNumber;
    }
  
    public int get_accountNumber () {
        return _accountNumber;
    }
  
    public void set_accountBalance (int accountBalance) {
        _accountBalance = accountBalance;
    }
  
    public int get_accountBalance () {
        return _accountBalance;
    }
  }