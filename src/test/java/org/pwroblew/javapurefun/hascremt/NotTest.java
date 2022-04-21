package org.pwroblew.javapurefun.hascremt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;
import static org.pwroblew.javapurefun.hascremt.Is.is;
import static org.pwroblew.javapurefun.hascremt.Not.not;

class NotTest {

    @Test
    void testNotEqualToFivePasses() {
        var matchResult = not(equalTo(5)).match(6);
        assertEquals(true, matchResult._1());
        assertEquals( "equal to <6>", matchResult._2().toString());
    }

    @Test
    void testNotEqualToFiveFails() {
        var matchResult = not(equalTo(5)).match(5);
        assertEquals(false, matchResult._1());
        assertEquals( "equal to <5>", matchResult._2().toString());
    }


    @Test
    void testDescribe() {
        var notEqualToFiveDescription = not(equalTo(5)).describe().toString();
        assertEquals( "not equal to <5>", notEqualToFiveDescription);
    }
}