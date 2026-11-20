import java.util.Comparator;
public class CustomComparator implements Comparator {
    private long coding(Object object) {
        if (object == null) return 0;
        else if (object instanceof Boolean) {
            Boolean booleanObject = (Boolean) object;
            if (booleanObject == false) return Integer.MIN_VALUE - 1;
            else return Integer.MIN_VALUE - 2;
        }
        else if (object instanceof String) {
            String stringObject = (String) object;
            return stringObject.hashCode();
        }
        else if (object instanceof Integer) return ((Integer) object).intValue();
        else return 0;
    }
    @Override
    public int compare(Object o1, Object o2) {
        return (int) (coding(o2) - coding(o1));
    }
}