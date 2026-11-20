public class Journal implements Media{
    private String name;
    public Journal(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void afficher(){
        System.out.println("- Name of journal: "+name);
    }

}
