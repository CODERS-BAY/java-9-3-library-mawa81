import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Person {

    private String name;
    private List<Book> rentalBooks;
    private Date borrowed;
    private Date returned;
    private Integer credits;

    //               !!!!!!!!!!!!!!!!!!!!!! This Constructor needs work !!!!!!!!!!!!!!!!!!!!!!!!!!!

    public Person(String name, List<Book> rentalBooks, Date borrowed, Date returned, Integer credits) {
        this.name = name;
        this.rentalBooks = rentalBooks;
        this.borrowed = borrowed;
        this.returned = returned;
        this.credits = credits;
    }

    public void rents(Book book, Date borrowed) {
        if (credits >= 5) {
            rentalBooks.add(book);
        } else {
            System.out.println("You have top up your credits!");
        }
    }

    public void returns(Book book, Date returned) {
        if (credits >= 5) {
            rentalBooks.remove(book);
            Integer difference = Math.toIntExact(getDifferenceDays(borrowed, returned));
            System.out.println(difference);
        } else {
            System.out.println("You have top up your credits!");
        }
    }

    private Long getDifferenceDays(Date d1, Date d2) {
        Long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
