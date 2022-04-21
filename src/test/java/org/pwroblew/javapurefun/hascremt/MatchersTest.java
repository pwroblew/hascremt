package org.pwroblew.javapurefun.hascremt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;
import static org.pwroblew.javapurefun.hascremt.Is.is;
import static org.pwroblew.javapurefun.hascremt.MatcherAssert.assertThat;
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

        var expectedMessage = "\nExpected: is equal to <5>\n" +
                "  Actual: is equal to <6>";

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

        var expectedMessage = "\nExpected: is not equal to <5>\n" +
                "  Actual: is equal to <5>";

        assertEquals(expectedMessage, exception.getMessage());
    }

}