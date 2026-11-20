
/**
 * Write a description of class Retrait here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Retrait
{
   private StringBuffer sbRetrait=new StringBuffer();
   
   String getRetrait(){
       return sbRetrait.toString();
   }
   
   void augmenterRetrait(){
       sbRetrait.append("___");
   }
    
   void diminuerRetrait(){
       sbRetrait.setLength(sbRetrait.length()-3);
    }

}
