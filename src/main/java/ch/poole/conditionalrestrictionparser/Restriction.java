package ch.poole.conditionalrestrictionparser;

import java.util.List;

/**
 * Container for an OpenStreetMap conditional restriction
 * @see <a href="http://wiki.openstreetmap.org/wiki/Conditional_restrictions">conditional restrictions on the OpenStreetMap wiki</a>
 * @author simon
 *
 */
public class Restriction {
	String value;
	final Conditions conditions;
	
	public Restriction(String value,Conditions conditions) {
		this.value = value;
		this.conditions = conditions;
	}
	
	/**
	 * @return the value of the restriction if the conditions are true
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Set the value of the restriction if the conditions are true
	 * 
	 * @param value the value the restriction should evaluate to
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * @return a List containing the conditions
	 */
	public List<Condition> getConditions() {
		return conditions.getConditions();
	}
	
	/**
	 * Add c to the list of conditions for this restriction
	 * 
	 * @param c  the Condition we want to add
	 */
	public void addCondition(Condition c) {
		conditions.addCondition(c);
	}

	/**
	 * Remove c from the list of conditions
	 * 
	 * @param c  the Condition we want to remove
	 */
	public void removeCondition(Condition c) {
		conditions.removeCondition(c);
	}
	
	/**
	 * Indicate that these conditions need to be enclosed in parentheses
	 */
	public void setInParen() {
		conditions.setInParen();
	}
	
	public String prettyPrint() {
		return value + " @\n" + conditions.prettyPrint();
	}

	@Override
	public String toString() {
		return value + " @ " + conditions.toString();
	}
}
