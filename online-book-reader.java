public class Solution {
    public class Library {
        ArrayList<Book> books = new ArrayList<Book>();
        public Book searchBookByTitle(String title) {}
        public Book searchBookByAuthor(String author) {}
        public Book searchBookByPublisher(String publisher) {}
        public Book searchBookByISBN(int ISBN) {}
        public void addNewBook(Book newBook) {
            books.add(newBook);
        }
    }
    public class Book {
        int ISBN;
        String title, author, publisher;
        int yearOfPub, numPages;
        double weight;
        public Book(int ISBN, String title, String author, String publisher, int yeaerOfPub, int numPages, double weight) {}
    }
    public class User {
        Book readingBook;
        boolean isMember;
        int lastMembershipRenewed = 0;
    }
    public static void main(String args[]) {
    }

}
