import java.awt.*;
class AppliWindow4
{
    public static void main(String [ ] arg) {

        Frame fen = new Frame ("Bonjour" );
        fen.setBounds (100, 100, 250, 150);
        fen. setVisible ( true );
        fen.setLayout(new FlowLayout( ));        
        Button entrez = new Button("Entrez");
        Checkbox bout1 = new Checkbox("Choix 1");
        Checkbox bout2 = new Checkbox("Choix 2");
        fen.add(entrez);
        fen.add(bout1);  fen.add(bout2);
        
        // les menus :
        MenuBar mbar = new MenuBar( );
        Menu meprinc1 = new Menu("Fichier");
        Menu meprinc2 = new Menu("Edition");
        MenuItem item1 = new MenuItem("choix n°1");
        MenuItem item2 = new MenuItem("choix n° 2");
        fen.setMenuBar(mbar);
        meprinc1.add(item1);  meprinc1.add(item2);
        mbar.add(meprinc1);   mbar.add(meprinc2);
        
        
        fen.setVisible ( true );
    }
}

    
        

