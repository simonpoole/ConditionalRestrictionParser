package ch.poole.conditionalrestrictionparser;

import java.util.Collections;
import java.util.List;

public class Conditions {
	final List<Condition> conditions;
	boolean conditionsInParen = false;
	
	public Conditions(final List<Condition> conditions, boolean conditionsInParen) {
		this.conditions = conditions;
		this.conditionsInParen = conditionsInParen;
	}

	public List<Condition> getConditions() {
		return conditions;
	}
	
	public boolean inParen() {
		return conditionsInParen;
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
