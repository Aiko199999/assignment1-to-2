public class Main {
    public static void main(String[] args) {
        Rectangle figure = new Rectangle(2, 3);
        Rectangle figure2 = new Rectangle(3, 5);
        Book read = new Book("Death on Nile", "Agatha Christie", 1937);
        LibraryApp app = new LibraryApp();
        System.out.println(figure);
        System.out.println(read);
        app.run();
    }
}