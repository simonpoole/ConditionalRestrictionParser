
package ch.poole.conditionalrestrictionparser;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.Test;

/**
 * Tests for the OpeningHoursParser
 * 
 * @author Simon Poole
 *
 */
public class ConditionalRestrictionParserTest {
	@Test
	public void test() {
		ConditionalRestrictionParser parser = new ConditionalRestrictionParser(new ByteArrayInputStream("50 @ hgv AND vehicle ; 70 @ 10:00-12:00 ; 40 @ \"; @ AND\"".getBytes()));

		try {
			List<Restriction> rs = parser.restrictions();
			for (Restriction r:rs) {
				System.out.println(r.toString());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
