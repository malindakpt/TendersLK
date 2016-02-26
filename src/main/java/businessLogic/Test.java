package businessLogic;

/**
 * Created by MalindaK on 2/24/2016.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Test Started");
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase(null);
    }
}
