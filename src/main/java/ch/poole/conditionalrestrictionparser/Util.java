package ch.poole.conditionalrestrictionparser;

import java.util.List;

public final class Util {
    
    /**
     * Private constructor to inhibit instantiation
     */
    private Util() {
        // empty
    }
	
	/**
     * @param restrictions List of restrictions we want to convert
     * @return turn restrictions in to a string representation
     */
    public static String restrictionsToString(List<Restriction> restrictions) {
        return restrictionsToString(restrictions, true);
    }

    /**
	 * @param restrictions List of restrictions we want to convert
	 * @param keepEmpty produce something for empty conditiions
	 * @return turn restrictions in to a string representation
	 */
	public static String restrictionsToString(List<Restriction> restrictions, boolean keepEmpty) {
		StringBuilder result = new StringBuilder();
		for (Restriction r:restrictions) {
			if (result.length() != 0) {
				result.append("; ");
			}
			result.append(r.toString(keepEmpty));
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
