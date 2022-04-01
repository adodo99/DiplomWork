package DiplomProject;


public class Main {
    public static void main(String[] args){
        User.userList.add(new User(16,"Denis","Chornii",true));
        User.userList.add(new User(12,"Alex","Frost",true));
        User.userList.add(new User(25,"Igor","Berdis",true));
        User.userList.add(new User(19,"Adil","Sheikh",true));
        Parking.showMenu();
    }
}
