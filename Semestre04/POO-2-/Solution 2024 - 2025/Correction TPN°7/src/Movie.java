public class Movie implements Media{
private String title;
public Movie (String title){
    this.title = title;
}
public String getTitle(){
    return title;
}
    public void afficher(){
        System.out.println("- Title of movie: "+title);
    }

}
