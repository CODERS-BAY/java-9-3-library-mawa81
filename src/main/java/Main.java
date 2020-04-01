public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Book book001 = new Book("Der Prozess", "Franz Kafka", "german", "novel", 223);
        Book book002 = new Book("Die Wand", "Marlen Haushofer", "german", "novel", 385);
        Book book003 = new Book("Brave New World", "Aldous Huxley", "english", "science fiction", 311);
        Book book004 = new Book("Emil und die Detektive", "Erich Kästner", "german", "children novel", 188);

        library.addBook(book001);
        library.addBook(book002);
        library.addBook(book003);
        library.addBook(book004);


        System.out.println(library.getAllBooks());
    }
}
