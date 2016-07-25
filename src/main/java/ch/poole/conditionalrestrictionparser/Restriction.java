package ch.poole.conditionalrestrictionparser;

import java.util.List;

public class Restriction {
	String value;
	final Conditions conditions;
	
	public Restriction(String value,Conditions conditions) {
		this.value = value;
		this.conditions = conditions;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public List<String> getConditions() {
		return conditions.getConditions();
	}
	
	@Override
	public String toString() {
		// note value part doesn't skip WS so don't add any there
		return value + "@ " + conditions.toString();
	}
}
