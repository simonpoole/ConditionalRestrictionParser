package ch.poole.conditionalrestrictionparser;

import java.util.List;

public class Conditions {
	final List<String> conditions;
	boolean conditionsInParen = false;
	
	public Conditions(final List<String> conditions, boolean conditionsInParen) {
		this.conditions = conditions;
		this.conditionsInParen = conditionsInParen;
	}

	public List<String> getConditions() {
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
		for (String s:conditions) {
			if (!first) {
				b.append(" AND ");
			} else {
				first = false;
			}
			b.append(s.trim());
		}
		if (conditionsInParen) {
			b.append(")");
		}
		return b.toString();
	}
}
