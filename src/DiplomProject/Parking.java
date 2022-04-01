package DiplomProject;

import java.util.Scanner;

public class Parking {
    static Scanner scanner=new Scanner(System.in);
    private static int placesCount=200;
    private static final int coast=5;
    private static final int vipCoast=20;

    //метод используемый для проверки правильности введенных значений int
    // возвращаемый параметр int
    public static int userInput(){
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()){
            int input = scanner.nextInt();
            return input;
        }else{
            System.out.println("нет такого варианта\n" +
                    "пожалуйста введите в корректном формате");
            scanner.nextLine();
        }return userInput();
    }

    //метод вывода меню и вызываемый в нем метод выбора пользователя с входным int параметром
    //ничего не возвращает
    public static void showMenu(){
        System.out.println("Добро пожаловать на парковку №1 в мире\n" +
                "1.добавить нового пользователя\n"+
                "2.авторизация\n" +
                "3.Показать существующих пользователей \n" +
                "4.Арендовать парковочное место \n" +
                "5.узнать сколько месть всего свободно \n" +
                "6.места для инвалидов\n" +
                "7.BlackList\n" +
                " ==================================================");
        choseMenu(scanner.nextInt());
    }

    //метод создания нового обьекта класса User с которым в дальнейшей должен сравниваться уже существующий User из userList
    //возвращает обьект класса User
    public static Object checkUser(){
        new User(userAge(),userFirstName(),userSecondName(), userInvalid());
        showMenu();
        return null;
    }

    //недоработаный метод авторизации,который долже перебирать userList и сравнивать его с новым экземпляром User
    //возвращает войд
    //вызывает меню
    public static void authorized() {
        System.out.println("Ведите ваши данные");
        User checkedUser = new User(userAge(), userFirstName(), userSecondName(), userInvalid());
        if (User.userList.listIterator().equals(checkedUser)){
            System.out.println("здравствуйте, "+checkedUser);
        }else {
            System.out.println("Неизвестный пользователь");
        }
//        if(checkUser().equals(User.userList.listIterator()));
        showMenu();
    }

    //метод не метод из-за неумения переопределять equals
    public static void invalidCheck(){
    }

    //метод вызываемый при добавлении нового Usera,для установки его возраста
    //возвращает int
    public static int  userAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш возраст");
        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            return input;
        } else {
            System.out.println("некорректный формат ввода");
        }
        scanner.hasNextLine();
        return userAge();
    }

    //метод вызываемый при добавлении нового Usera,для установки его имени
    //возвращает String
    public static String  userFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            return input;
        } else {
            System.out.println("некорректный формат ввода");
        }
        scanner.hasNextLine();
        return userFirstName();
    }

    //метод вызываемый при добавлении нового Usera,для установки его фамилии
    //возвращает String
    public static String  userSecondName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вашу фамилию");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            return input;
        } else {
            System.out.println("некорректный формат ввода");
        }
        scanner.hasNextLine();
        return userSecondName();
    }

    //метод вызываемый при добавлении нового Usera,для установки его статуса инвалидности
    //требует доработки без true/false(переопределения)
    //возвращает boolean
    public static boolean userInvalid() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("подтвердите свою инвалидность");
        if (scanner.hasNextBoolean()) {
            boolean input = scanner.nextBoolean();
            return input;
        } else {
            System.out.println("некорректный формат ввода");
        }
        scanner.hasNextLine();
        return userInvalid();
    }

//сам метод и вызываемые в нем придуманы по незнанию иного решения
    public static void createNewUser(){
        User.userList.add(new User(userAge(),userFirstName(),userSecondName(), userInvalid()));
        System.out.println("ваши данные успешно добавлены");
        showMenu();
    }


//метод показывающий всех Userов ,кривопереопределенный toString
    public static void showAllUsers(){
        System.out.println(User.userList);
        System.out.println("=====================================================");
        showMenu();
    }

    //метод вывода количества свободных мест парковки
    public static void freePlacesCount(){
        System.out.println("свободных мест осталось "+placesCount);
        System.out.println("=====================================================");
        showMenu();
    }

    //метод аренды парковочного места,в котором просчитывается стоимость и вычитается одно парковочное место
    public static void rentTheParkingPlace(){
        System.out.println("Введите время аренды(в минутах)");
        double daiDenejky=userInput()*coast/60.0;
        System.out.println("заплатите "+ daiDenejky +" Рублей");
        placesCount= placesCount-1;
        System.out.println("Мест свободно на парковке "+placesCount);
        System.out.println("=====================================================");
        showMenu();
    }

    //метод не метод из-за неумения переопределять equals
    public static void blackList(){
        showMenu();
    }

    // метод выбора пользователя
     public static void choseMenu(int personchose){
        switch (personchose){
            case 1:
                createNewUser();
                break;
            case 2:
                authorized();
                break;
            case 3:
                showAllUsers();
                break;
            case 4:
                rentTheParkingPlace();
                break;
            case 5:
                freePlacesCount();
                break;
            case 6:
                System.out.println("BetaTest");
                showMenu();
                break;
            case 7:
                System.out.println("BetaTest");
                break;
            default:
                System.out.println("error 404");
                showMenu();
        }
    }
}

