package ch.poole.conditionalrestrictionparser;

import java.util.Collections;
import java.util.List;

/**
 * Container for a list of Condition object plus a flag that indicates if they are enclosed in parentheses 
 * @author simon
 *
 */
public class Conditions {
	final List<Condition> conditions;
	boolean conditionsInParen = false;
	
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
	 * @param c
	 */
	public void addCondition(Condition c) {
		conditions.add(c);
	}
	
	/**
	 * Remove c from the list of conditions
	 * @param c
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
	
	public String prettyPrint() {
		StringBuilder b = new StringBuilder();
		if (conditionsInParen) {
			b.append("(\n");
		}
		boolean first = true;
		boolean multiple = conditions.size() > 1;
		for (Condition c:conditions) {
			if (!first) {
				b.append("\n AND ");
			} else {
				first = false;
				if (multiple) {
					b.append(" ");
				}
			}
			b.append(c);
		}
		if (conditionsInParen) {
			b.append("\n)");
		}
		return b.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		if (conditionsInParen) {
			b.append("(");
		}
		boolean first = true;
		for (Condition c:conditions) {
			if (!first) {
				b.append(" AND ");
			} else {
				first = false;
			}
			b.append(c);
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
