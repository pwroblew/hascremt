package org.pwroblew.javapurefun.hascremt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;
import static org.pwroblew.javapurefun.hascremt.Is.is;

class IsTest {

    @Test
    void testIsEqualToFivePasses() {
        var matchResult = is(equalTo(5)).match(5);
        assertEquals(true, matchResult._1());
        assertEquals( "is equal to <5>", matchResult._2().describe());
        assertEquals( "is equal to <5>", matchResult._2().explain());
    }

    @Test
    void testIsEqualToFiveFails() {
        var matchResult = is(equalTo(5)).match(6);
        assertEquals(false, matchResult._1());
        assertEquals( "is equal to <5>", matchResult._2().describe());
        assertEquals( "is equal to <6>", matchResult._2().explain());
    }

}