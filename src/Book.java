public class Book {
    private int id;
    private static int idGen=1;
    private String title;
    private String author;
    private int year;
    public boolean available;
    public Book(){
        this.id=idGen++;
        this.available=true;
    }
    public Book(String title,String author,int year){
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title==null||title.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if(author==null||author.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.author = author;
    }

    public void setYear(int year) {
        if(year>2025||year<1500){
            throw new IllegalArgumentException();
        }
        this.year = year;
    }
    public void markAsBorrowed(){
        this.available=false;
    }
    public void markAsReturned(){
        this.available=true;
    }

    @Override
    public String toString() {
        return "ID: "+id+" "+"Title: "+title+" "+"Author: "+author+" "+"Year: "+year+" "+"Available status: "+available;
    }
}
