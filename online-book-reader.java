public class Solution {
    public class OnlineEBookReader {
        public Library library;
        public User user;
        public Display display;
        public Book activeBook;
        
        public OnlineEBookReader() {
            user = new User();
            library = new Library();
            display = new Display();
            activeBook = new Book();
        }
        public Book getActiveBook() { return activeBook;}
        public void setActiveBook(Book activeBook) {
            this.activeBook = activeBook;
            display.showBook(activeBook);
        }
        public User getActiveUser() { return activeUser;}
        public void setActiveUser(User activeUser) {
            this.activeUser = activeUser;
            display.showUser(activeUser);
        }
    }
    public class Library {
        HashMap<Integer, Book> books = new HashMap<Integer, Book>();
        public Book searchBookByTitle(String title) {}
        public Book searchBookByAuthor(String author) {}
        public Book searchBookByPublisher(String publisher) {}
        public Book searchBookByISBN(int ISBN) {
            return books.get(ISBN);
        }
        public void addNewBook(Book newBook) {
            if (books.containsKey(newBook.ISBN)) return null;
            books.put(newBook.ISBN, newBook);
        }
        public void removeBook(int ISBN) {
            if (books.containsKey(ISBN)) books.remove(ISBN);
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
        boolean isMember;
        int lastMembershipRenewed = 0;
        int membershipDuration = 90; // days
        public void renewMembership() {
            isMember = true;
            lastMembershipRenewed += membershipDuration;
        }
    }
    public class Display {
        Book activeBook;
        User activeUser;
        int currentPage;
        public void nextPage() {
            if (currentPage == activeBook.numPages) return;
            else currentPage++;
        }
        public void previousPage() {
            if (currentPage == 0) return;
            else currentPage--;
        }
        public void displayUser(User user) {
            activeUser = user;
        }
        public void displayBook(Book book) {
            currentPage = 0;
            activeBook = book;
        }
    }
    public static void main(String args[]) {
    }

}
