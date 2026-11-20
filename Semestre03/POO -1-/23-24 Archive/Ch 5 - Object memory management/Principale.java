package exercise02;

/**
 * Test Class for the lab #9 (exercise 02).
 */
public class Principale {
    /**
     * The line separator.
     * @remark Some Operating Systems consider a different value for their line separator.
     * @example For example, Windows use the '\n'.
     * @example Otherwise, some Linux Distributions consider other characters as line separators.
     * @question Can you explain the display ?
     * @question Can you do the same for the exercise 01 ? Have it the same behavior as the exercise 02 ?
     */
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * In addition of the garbage collector, the method displays some memory primitives calls results
     * @param args not used
     * @remark You can use the JavaDoc to check the primitives roles.
     */
    public static void main(String[] args) {
        System.out.format("%8s | %15s | %15s | %15s%s", "Etape", "Total", "Free", "Maximal", LINE_SEPARATOR);
        System.out.format("%8s | %015d | %015d | %015d%s", "Etape 01", Runtime.getRuntime().totalMemory(), Runtime.getRuntime().freeMemory(), Runtime.getRuntime().maxMemory(), LINE_SEPARATOR);
        O3 unO3 = new O3();
        System.out.format("%8s | %015d | %015d | %015d%s", "Etape 02", Runtime.getRuntime().totalMemory(), Runtime.getRuntime().freeMemory(), Runtime.getRuntime().maxMemory(), LINE_SEPARATOR);
        unO3 = null;
        System.out.format("%8s | %015d | %015d | %015d%s", "Etape 03", Runtime.getRuntime().totalMemory(), Runtime.getRuntime().freeMemory(), Runtime.getRuntime().maxMemory(), LINE_SEPARATOR);
        System.gc();
        System.out.format("%8s | %015d | %015d | %015d%s", "Etape 04", Runtime.getRuntime().totalMemory(), Runtime.getRuntime().freeMemory(), Runtime.getRuntime().maxMemory(), LINE_SEPARATOR);
    }
}

/**
 * Output :
 *    Etape |           Total |            Free |         Maximal
 * Etape 01 | 000000067108864 | 000000065286696 | 000001065353216
 * Etape 02 | 000000067108864 | 000000064862408 | 000001065353216
 * Etape 03 | 000000067108864 | 000000064862408 | 000001065353216
 * Etape 04 | 000000008388608 | 000000007258936 | 000001065353216
 * */
