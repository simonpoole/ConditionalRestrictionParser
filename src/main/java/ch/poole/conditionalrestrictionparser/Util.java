package ch.poole.conditionalrestrictionparser;

import java.util.List;

public class Util {
	
	/**
     * @param restrictions List of restrictions we want to convert
     * @return turn restrictions in to a string representation
     */
    public static String restrictionsToString(List<Restriction> restrictions) {
        return restrictionsToString(restrictions, true);
    }

    /**
	 * @param restrictions List of restrictions we want to convert
	 * @param keepEmptyCondition produce something for ampty conditiions
	 * @return turn restrictions in to a string representation
	 */
	public static String restrictionsToString(List<Restriction> restrictions, boolean keepEmptyConditions) {
		StringBuilder result = new StringBuilder();
		for (Restriction r:restrictions) {
			if (result.length() != 0) {
				result.append("; ");
			}
			result.append(r.toString(keepEmptyConditions));
		}
		return result.toString();
	}
	
	public static String prettyPrint(List<Restriction> restrictions) {
		StringBuilder result = new StringBuilder();
		for (Restriction r:restrictions) {
			if (result.length() != 0) {
				result.append(";\n");
			}
			result.append(r.prettyPrint());
		}
		return result.toString();
	}
}
