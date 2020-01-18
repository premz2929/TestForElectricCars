
public class Main {

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        user.TestQA();
        user.login();
        user.newTeslaQuery();
        user.enterToQuery();
        user.editQuery();
        user.deleteQuery();
        user.logout();
        user.login();
        user.logout();

        Admin admin = new Admin();
        admin.openSite();
        admin.login();
        admin.getString();
        admin.newTeslaQuery();
        admin.editQuery();
        admin.deleteQuery();
        admin.logout();
        admin.addNewCar();
        admin.deleteCar();
        admin.editCar();
        admin.addNewUser();
        admin.editUser();


    }
}
