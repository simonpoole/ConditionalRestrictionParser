package ch.poole.conditionalrestrictionparser;

import java.util.Arrays;
import java.util.List;

/**
 * Container for a OSM condition
 * 
 * @author simon
 *
 */
public class Condition {
    boolean OH = false;
    String  c;
    String  c2;

    public static enum CompOp {
        EQ, GT, GTEQ, LT, LTEQ
    }

    CompOp                     op            = null;
    public static List<String> compOpStrings = Arrays.asList("=", ">", ">=", "<", "<=");

    public Condition(String c, boolean OH) {
        this.c = c.trim();
        this.OH = OH;
    }

    public Condition(String c, CompOp op, String c2) {
        this.c = c.trim();
        this.op = op;
        this.c2 = c2.trim();
    }

    @Override
    public String toString() {
        return c.trim() + (op != null ? opToString(op) + c2.trim() : "");
    }

    /**
     * Return a string representation of the comparison operator op
     * 
     * @param op the CompOp we want the string representation for
     * @return the string, empty if not found (can't happen)
     */
    public static String opToString(CompOp op) {
        switch (op) {
        case EQ:
            return "=";
        case GT:
            return ">";
        case GTEQ:
            return ">=";
        case LT:
            return "<";
        case LTEQ:
            return "<=";
        default:
            return "";
        }
    }

    /**
     * Return the enum value corresponding to the string
     * 
     * @param s String we want the COmpOp for
     * @return null if not a recognized comparison operator
     */
    public static CompOp stringToOp(String s) {
        if ("=".equals(s)) {
            return CompOp.EQ;
        } else if (">".equals(s)) {
            return CompOp.GT;
        } else if (">=".equals(s)) {
            return CompOp.GTEQ;
        } else if ("<".equals(s)) {
            return CompOp.LT;
        } else if ("<=".equals(s)) {
            return CompOp.LTEQ;
        }
        return null;
    }

    /**
     * @return true if this is an OH spec
     */
    public boolean isOpeningHours() {
        return OH;
    }

    /**
     * @return true if this is an expression
     */
    public boolean isExpression() {
        return op != null && c2 != null;
    }

    /**
     * @return the first term of a comparison expression
     */
    public String term1() {
        return c;
    }

    /**
     * Set the first term of an expression
     * 
     * @param term value to set
     */
    public void setTerm1(String term) {
        c = term;
    }

    /**
     * @return the second term of a comparison expression
     */
    public String term2() {
        return c2;
    }
    
    /**
     * Set the second term of an expression
     * 
     * @param term value to set
     */
    public void setTerm2(String term) {
        c2 = term;
    }

    /**
     * @return the comparison operator
     */
    public CompOp operator() {
        return op;
    }
}
