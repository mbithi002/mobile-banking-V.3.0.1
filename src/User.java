import java.util.ArrayList;
import java.util.List;

public class User extends Accounts{
  private String _password;
  private String _userName;
  private List<Accounts> _accounts;

  public User(String userName, String password, int accountNumber, int accountBalance) {
    super(accountNumber, accountBalance);
      _password = password;
      _userName = userName;
      _accounts = new ArrayList<>();
  }

  void set_password(String password) {
      _password = password;
  }

  String get_password() {
      return _password;
  }

  void set_userName(String userName) {
      _userName = userName;
  }

  String get_userName() {
      return _userName;
  }

  public void addAccount(Accounts account) {
    _accounts.add(account);
  }
}