package hello1;
import hello1.myUser;

public interface  myUserDAO {
    void insert(myUser user);
    myUser findById(int id);
}
