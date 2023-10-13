import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Friend {
    private String name;
    private LocalDate birthday;

    public Friend(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}

public class Main {
    public List<Friend> friends;
    public List<String> before;
    public List<String> after;
    public List<String> birthday_today;

    public Main() {
        friends = new ArrayList<>();
        before = new ArrayList<>();
        after = new ArrayList<>();
        birthday_today = new ArrayList<>();
    }
    public void addFriend(String name, LocalDate birthday) {
        Friend friend = new Friend(name, birthday);
        friends.add(friend);
    }
    public void showUpcomingBirthdays() {
        LocalDate today = LocalDate.now();
        String s;
        for (Friend friend : friends) {
            LocalDate nextBirthday = LocalDate.of(today.getYear(), friend.getBirthday().getMonthValue(), friend.getBirthday().getDayOfMonth());
            if (nextBirthday.isAfter(today)) {
                long daysUntilBirthday = today.until(nextBirthday).getDays();
                s = friend.getName() + " будет праздновать день рождения через " + daysUntilBirthday + " дней!";
                after.add(s);
            }
            if (nextBirthday.isEqual(today)) {
                s = friend.getName() + " празднует день рождения сегодня!!!";
                birthday_today.add(s);
            }
        }
        for (String str: after){
            System.out.println(str);
        }
        for (String str: birthday_today){
            System.out.println(str);
        }
    }

    public void showPastBirthdays() {
        LocalDate today = LocalDate.now();
        String s;
        for (Friend friend : friends) {
            LocalDate lastBirthday = LocalDate.of(today.getYear(), friend.getBirthday().getMonthValue(), friend.getBirthday().getDayOfMonth());
            if (lastBirthday.isBefore(today)) {
                s = friend.getName() + " праздновал свое день рождения " + today.getYear() + "-" + friend.getBirthday().getMonthValue() + "-" + friend.getBirthday().getDayOfMonth();
                before.add(s);
            }
        }
        for (String str: before){
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Main reminder = new Main();
        // Adding friends
        reminder.addFriend("Иван", LocalDate.of(2000, 3, 15));
        reminder.addFriend("Максим", LocalDate.of(2000, 10, 25));
        reminder.addFriend("Стёпа", LocalDate.of(2000, 7, 5));
        System.out.println("Выберете действие:\n [1]Ввести день рождение друга\n [2]Посмотреть предстоящие дни рождения\n [3]Посмотреть прошедшие дни рождения\n");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        switch (choice){
            case 1:
                System.out.println("Введите имя\n");
                String name = s.nextLine();
                System.out.println("Введите год\n");
                int year = s.nextInt();
                System.out.println("Введите месяц\n");
                int month = s.nextInt();
                System.out.println("Введите день\n");
                int day = s.nextInt();
                reminder.addFriend(name, LocalDate.of(year, month, day));
                break;
            case 2:
                reminder.showUpcomingBirthdays();
                break;
            case 3:
                reminder.showPastBirthdays();
                break;
        }
    }
}