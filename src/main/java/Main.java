public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Book book1 = new Book("Der Prozess", "Franz Kafka", "german", "novel", 223, 5);
        Book book2 = new Book("Die Wand", "Marlen Haushofer", "german", "novel", 385, 10);
        Book book3 = new Book("Brave New World", "Aldous Huxley", "english", "science fiction", 255, 10);
        Book book4 = new Book("Emil und die Detektive", "Erich Kästner", "german", "children novel", 150, 1);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Person person1 = new Person("Hans Huber");
        Person person2 = new Person("Doris Dobusch");
        Person person3 = new Person("Samuel Sonnig");
        Person person4 = new Person("Hanna Honig");
        Person person5 = new Person("Moritz Muster");

        library.addPerson(person1);
        library.addPerson(person2);
        library.addPerson(person3);
        library.addPerson(person4);
        library.addPerson(person5);

        person1.addCredits(100);
        person1.rents(book2, "2020-03-06");
        person1.rents(book1, "2020-03-07");
        person1.rents(book3, "2020-03-07");
        person1.rents(book4, "2020-03-07");

        person1.returns(book1, "2020-03-14");
        person1.returns(book2, "2020-04-08");
        person1.returns(book2, "2020-04-08");
        person1.returns(book3, "2020-04-08");
        person1.addCredits(1000);
        person1.returns(book3, "2020-04-08");


        System.out.println("Actual loans of " + person1.getName() + ": " + person1.getLoansActually());
        System.out.println();
        System.out.println("History of loans of " + person1.getName() + ": " + person1.getLoansHistory());
        System.out.println();
        System.out.println("Actual loans of " + person3.getName() + ": " + person3.getLoansActually());
        System.out.println();
        System.out.println("History of loans of " + person3.getName() + ": " + person3.getLoansHistory());


        System.out.println("List of all books available in the library: \n" + library.getAllBooks());
        System.out.println();
        System.out.println("List of all library customers: \n" + library.getAllPersons());
        System.out.println();

    }
}
