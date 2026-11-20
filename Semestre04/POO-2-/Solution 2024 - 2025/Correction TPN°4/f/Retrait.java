package f;
public class Retrait {
    private StringBuffer sbRetrait;
    public Retrait(){
        sbRetrait = new StringBuffer();
    }
    public void augmenterRetrait(){
        sbRetrait.append("___");
    }
    public void diminuerRetrait(){
        sbRetrait.setLength(sbRetrait.length() - 3 );
    }
    public StringBuffer getSbRetrait() {
        return sbRetrait;
    }
}
