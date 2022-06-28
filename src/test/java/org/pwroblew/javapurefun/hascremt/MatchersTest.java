package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;
import static org.pwroblew.javapurefun.hascremt.Is.is;
import static org.pwroblew.javapurefun.hascremt.MatcherAssert.assertThat;
import static org.pwroblew.javapurefun.hascremt.Matchers.rmap;
import static org.pwroblew.javapurefun.hascremt.Not.not;

class MatchersTest {
    @Test
    void testIsEqualToFivePositive() {
        assertThat(5, is(equalTo(5)));
    }

    @Test
    void testIsEqualToFiveNegative() {
        AssertionError exception = assertThrows(AssertionError.class, () ->
                assertThat(6, is(equalTo(5))));

        var expectedMessage = """

                Expected: is equal to <5>
                  Actual: is equal to <6>""";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testIsNotEqualToSix() {
        assertThat(6, is(not(equalTo(5))));
    }

    @Test
    void testIsNotEqualToFiveNegative() {
        AssertionError exception = assertThrows(AssertionError.class, () ->
                assertThat(5, is(not(equalTo(5)))));

        var expectedMessage = """

                Expected: is not equal to <5>
                  Actual: is equal to <5>""";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testRMap() {
        Matcher<String> lengthMatcher = rmap(String::length, equalTo(5)).descriptionPrefix("String->length");
        final Tuple2<Boolean, Description> matchResult = lengthMatcher.match("aaaaa");

        assertEquals( true, matchResult._1());
        assertEquals("String->length equal to <5>", matchResult._2().describe());
        assertEquals("String->length of <aaaaa> equal to <5>", matchResult._2().explain());
    }

    @Test
    void testRMap_2() {
        Matcher<String> lengthMatcher = rmap(String::length, equalTo(5)).descriptionPrefix("String->length");
        final Tuple2<Boolean, Description> matchResult = lengthMatcher.match("aaaaaa");

        assertEquals( false, matchResult._1());
        assertEquals("String->length equal to <5>", matchResult._2().describe());
        assertEquals("String->length of <aaaaaa> equal to <6>", matchResult._2().explain());
    }

}