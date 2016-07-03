package ch.poole.conditionalrestrictionparser;

import java.util.List;

public class Restriction {
	final String value;
	final List<String> conditions;
	
	Restriction(String value,List<String>conditions) {
		this.value = value;
		this.conditions = conditions;
	}
	
	public String toString() {
		if (conditions.size() == 1) {
			return value + " @ " + conditions.get(0);
		} else {
			StringBuilder b = new StringBuilder();
			b.append(value);
			b.append(" @ ( ");
			boolean first = true;
			for (String s:conditions) {
				if (!first) {
					b.append(" AND ");
				} else {
					first = false;
				}
				b.append(s);
			}
			b.append(" )");
			return b.toString();
		}
	}
}
