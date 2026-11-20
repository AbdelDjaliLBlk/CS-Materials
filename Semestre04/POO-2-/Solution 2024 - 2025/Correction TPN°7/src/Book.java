public class Book implements Media{
    private String isbn , title;

    public Book (String isbn , String title){
        this.isbn = isbn;
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void afficher(){
        System.out.println("- Isbn: "+isbn+". Title of book: "+title);
    }

}
