/**
 * 
 * @author Simon Poole
 *
 *         Copyright (c) 2015 Simon Poole
 *
 *         Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *         documentation files (the "Software"), to deal in the Software without restriction, including without
 *         limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
 *         Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 *         conditions:
 * 
 *         The above copyright notice and this permission notice shall be included in all copies or substantial portions
 *         of the Software.
 *
 *         THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 *         TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 *         THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 *         CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE " OR THE USE OR OTHER
 *         DEALINGS IN THE SOFTWARE.
 */

package ch.poole.conditionalrestrictionparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import ch.poole.conditionalrestrictionparser.Condition.CompOp;

/**
 * Tests for the ConditionalRestrictionParser
 * 
 * @author Simon Poole
 *
 */
public class UnitTest {

    @Before
    public void setUp() {
        I18n.setLocale(Locale.ROOT);
    }

    @Test
    public void numericComparisonTest() {
        try {
            ConditionalRestrictionParser parser = new ConditionalRestrictionParser(new ByteArrayInputStream("100 @ (weight<=3.5); 70 @ weight>3.5".getBytes()));
            List<Restriction> rs = parser.restrictions();
            assertEquals(2, rs.size());
            Restriction r1 = rs.get(0);
            assertEquals("100", r1.getValue());
            assertTrue(r1.inParen());
            List<Condition> cs = r1.getConditions();
            assertEquals(1, cs.size());
            Condition c1 = cs.get(0);
            assertTrue(c1.isExpression());
            assertFalse(c1.isOpeningHours());
            assertEquals("weight", c1.term1());
            assertEquals("3.5", c1.term2());
            assertEquals(CompOp.LTEQ, c1.operator());
            Restriction r2 = rs.get(1);
            assertEquals("70", r2.getValue());
            assertFalse(r2.inParen());
            assertEquals("70 @" + System.lineSeparator() + "weight>3.5", r2.prettyPrint());
            assertEquals("100 @" + System.lineSeparator() + "(" + System.lineSeparator() + " weight<=3.5" + System.lineSeparator() + ");"
                    + System.lineSeparator() + "70 @" + System.lineSeparator() + "weight>3.5", Util.prettyPrint(rs));
        } catch (ParseException pex) {
            fail(pex.getMessage());
        }
    }

    @Test
    public void ohTest() {
        try {
            ConditionalRestrictionParser parser = new ConditionalRestrictionParser(new ByteArrayInputStream("100 @ (Mo-Su sunset-21:00)".getBytes()));
            List<Restriction> rs = parser.restrictions();
            assertEquals(1, rs.size());
            Restriction r1 = rs.get(0);
            assertEquals("100", r1.getValue());
            assertTrue(r1.inParen());
            List<Condition> cs = r1.getConditions();
            assertEquals(1, cs.size());
            Condition c1 = cs.get(0);
            assertFalse(c1.isExpression());
            assertTrue(c1.isOpeningHours());
        } catch (ParseException pex) {
            fail(pex.getMessage());
        }
    }

    @Test
    public void translationSupport() {
        I18n.setLocale(Locale.GERMAN);
        try {
            ConditionalRestrictionParser parser = new ConditionalRestrictionParser(new ByteArrayInputStream("yes @ (Mo-Su sunset-21:00); no".getBytes()));
            List<Restriction> rs = parser.restrictions();
            fail("this should have thrown an exception");
        } catch (ParseException pex) {
            assertEquals("Gefunden: <EOF> bei Zeile 1, Spalte 30" + System.lineSeparator() + "Erwartet: \"@\" ...", pex.getMessage());
        }
    }
}
