package libraryManagement;

public class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public int compareTo(Book other) {
        // Sort by title ignoring case
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "Book {" +
                "ID='" + bookId + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                '}';
    }
}
