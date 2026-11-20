import java.awt.*;
class AppliWindow3 {
    public static void main(String [ ] arg) {
        Frame fen = new Frame ("Bonjour" );
        fen.setBounds (100, 100, 250, 150);
        fen.setLayout(new FlowLayout( ));        
        Button entrez = new Button("Entrez");
        Checkbox bout1 = new Checkbox("Choix 1");
        Checkbox bout2 = new Checkbox("Choix 2");
        fen.add(entrez);
        fen.add(bout1);  fen.add(bout2);
        fen.setVisible ( true );
    }
}
