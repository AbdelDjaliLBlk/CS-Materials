class Principale {
    public static void main (String [] args) {    
        Guerrier nG1 = new NainGuerrier("Gimli", 5,5, 8);    
        Guerrier nG2 = new NainGuerrier("Farin", 5,6, 12);    
        ((NainGuerrier)nG2).attaque((NainGuerrier)nG1);    
        ((NainGuerrier)nG2).attaque((NainGuerrier)nG1);    
        System.out.print(((NainGuerrier)nG1).pointsVie);    
        System.out.println(((NainGuerrier)nG1).parler());
        
        //Arène de gladiateurs
        /*
        NainGuerrier NG [] = new NainGuerrier [10];
        for (int i=0;i<10;i++)
            NG[i]=new NainGuerrier("Gimli"+i, i,i, i*2+1);
        
        Double d1=new Double(10*Math.random());       
        int n1=d1.intValue();   
        Double d2=new Double(10*Math.random());       
        int n2=d2.intValue();   
        NG[n1].attaque(NG[n2]);
        int i=0;
        while ( i<500) {
            d1=new Double(10*Math.random());       
            n1=d1.intValue();   
            d2=new Double(10*Math.random());       
            n2=d2.intValue();   
            NG[n1].attaque(NG[n2]);
            System.out.println(n2+ "   " + NG[n2]+"   "+NG[n2].pointsVie);
            i++;
        }
        for (n1=0;n1<10;n1++)
            System.out.println(n1+ "   " + NG[n1]+"   "+NG[n1].pointsVie);
            */
    }    
}