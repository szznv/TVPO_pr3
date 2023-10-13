import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;


public class MainTest {
    private Main reminder;

    @Before
    public void setUp() {
        reminder = new Main();
    }

    @Test
    public void testAddFriend() {
        reminder.addFriend("Иван", LocalDate.of(2000, 3, 15));
        reminder.addFriend("Максим", LocalDate.of(2000, 10, 25));
        reminder.addFriend("Стёпа", LocalDate.of(2000, 7, 5));

        Assert.assertEquals(3, reminder.friends.size());
    }

    @Test
    public void testRemindUpcomingBirthdays() {
        reminder.addFriend("Иван", LocalDate.of(2000, 3, 15));
        reminder.addFriend("Максим", LocalDate.of(2000, 10, 25));
        reminder.addFriend("Стёпа", LocalDate.of(2000, 10, 13));

        reminder.showUpcomingBirthdays();
        Assert.assertEquals("Максим будет праздновать день рождения через 12 дней!", reminder.after.get(0));
        Assert.assertEquals("Стёпа празднует день рождения сегодня!!!", reminder.birthday_today.get(0));
    }

    @Test
    public void testShowPastBirthdays() {
        reminder.addFriend("Иван", LocalDate.of(2000, 3, 15));
        reminder.addFriend("Максим", LocalDate.of(2000, 10, 25));

        reminder.showPastBirthdays();
        Assert.assertEquals("Иван праздновал свое день рождения " + LocalDate.now().getYear() + "-3-15", reminder.before.get(0));

    }
}
