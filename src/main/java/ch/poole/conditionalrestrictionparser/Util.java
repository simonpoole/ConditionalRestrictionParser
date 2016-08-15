package ch.poole.conditionalrestrictionparser;

import java.util.List;

public class Util {
	public static String restrictionsToString(List<Restriction> restrictions) {
		StringBuilder result = new StringBuilder();
		for (Restriction r:restrictions) {
			if (result.length() != 0) {
				result.append("; ");
			}
			result.append(r);
		}
		return result.toString();
	}
}
