public class Exo1{
    public static void main(String[] args) {

        Library<Book> bookLibrary = new Library<>();

        // Ajout de quelques livres
        bookLibrary.addMedia(new Book("ISBN123", "Java Programming"));
        bookLibrary.addMedia(new Book("ISBN456", "Data Structures and Algorithms"));

        // Récupération du dernier livre ajouté
        Book lastBook = bookLibrary.retrieveLast();
        System.out.println("Last Book: " + lastBook.getTitle());

        // Création d'une instance de Library pour stocker des films
        Library<Movie> movieLibrary = new Library<>();

        // Ajout de quelques films
        movieLibrary.addMedia(new Movie("The Shawshank Redemption"));
        movieLibrary.addMedia(new Movie("Inception"));

        // Récupération du dernier film ajouté
        Movie lastMovie = movieLibrary.retrieveLast();
        System.out.println("Last Movie: " + lastMovie.getTitle());

        // Recuperation du denier media d'une Library vide (Exception)
        Library <Media> myLibrary = new Library<>();
        myLibrary.retrieveLast();

        // Utiliser UtilitaireMedia pour afficher les medias
        UtilitaireMedia.afficher(myLibrary.getElements());

    }
}