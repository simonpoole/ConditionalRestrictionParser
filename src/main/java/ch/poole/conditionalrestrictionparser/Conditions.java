package ch.poole.conditionalrestrictionparser;

import java.util.Collections;
import java.util.List;

/**
 * Container for a list of Condition object plus a flag that indicates if they are enclosed in parentheses
 * 
 * @author simon
 *
 */
public class Conditions {
    final List<Condition> conditions;
    boolean               conditionsInParen = false;

    public Conditions(final List<Condition> conditions, boolean conditionsInParen) {
        this.conditions = conditions;
        this.conditionsInParen = conditionsInParen;
    }

    /**
     * @return a List containing the conditions
     */
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Add c to the list of conditions for this restriction
     * 
     * @param c the Condition we want to add
     */
    public void addCondition(Condition c) {
        conditions.add(c);
    }

    /**
     * Remove c from the list of conditions
     * 
     * @param c the Condition we want to remove
     */
    public void removeCondition(Condition c) {
        conditions.remove(c);
    }

    /**
     * @return true if the conditions need to be enclosed in parentheses
     */
    public boolean inParen() {
        return conditionsInParen;
    }

    /**
     * Indicate that these conditions need to be enclosed in parentheses
     */
    public void setInParen() {
        conditionsInParen = true;
    }

    /**
     * Indicate that these conditions don't need to be enclosed in parentheses
     */
    public void clearInParen() {
        conditionsInParen = false;
    }

    public String prettyPrint() {
        StringBuilder b = new StringBuilder();
        if (conditionsInParen) {
            b.append("(" + System.lineSeparator());
        }
        boolean first = true;
        for (Condition c : conditions) {
            if (!first) {
                b.append(System.lineSeparator());
                if (conditionsInParen) {
                    b.append(" ");
                }
                b.append("AND ");
            } else {
                first = false;
                if (conditionsInParen) {
                    b.append(" ");
                }
            }
            b.append(c);
        }
        if (conditionsInParen) {
            b.append(System.lineSeparator() + ")");
        }
        return b.toString();
    }

    @Override
    public String toString() {
        return toString(true);
    }

    /**
     * Convert the object to a String representation
     * 
     * @param keepEmpty keep in pricinple empty or incomplete elements
     * @return a String representation of the object
     */
    public String toString(boolean keepEmpty) {
        StringBuilder b = new StringBuilder();
        if (conditionsInParen) {
            b.append("(");
        }
        boolean first = true;
        for (Condition c : conditions) {
            String term1 = c.term1();
            if ((term1 != null && !"".equals(term1)) || keepEmpty) {
                if (!first) {
                    b.append(" AND ");
                } else {
                    first = false;
                }
                b.append(c);
            }
        }
        if (conditionsInParen) {
            b.append(")");
        }
        return b.toString();
    }

    public void reverse() {
        Collections.reverse(conditions);
    }
}
