public class Book {
    private String title;
    private String author;
    private String language;
    private String genre;
    private Integer pages;

    public Book(String title, String author, String language, String genre, Integer pages) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.genre = genre;
        this.pages = pages;
    }

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.language = "Unknown";
        this.genre = "Unknown";
        this.pages = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", language='" + getLanguage() + '\'' +
                ", genre='" + getGenre() + '\'' +
                ", pages=" + getPages() +
                '}';
    }
}
