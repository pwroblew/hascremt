package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;
import static org.pwroblew.javapurefun.hascremt.Is.is;

class IsTest {

    @Test
    void testIsEqualToFivePasses() {
        var matchResult = is(equalTo(5)).match(5);
        assertEquals(true, matchResult._1());
        assertEquals( "is equal to <5>", matchResult._2().toString());
    }

    @Test
    void testIsEqualToFiveFails() {
        var matchResult = is(equalTo(5)).match(6);
        assertEquals(false, matchResult._1());
        assertEquals( "is equal to <6>", matchResult._2().toString());
    }

    @Test
    void testDescribe() {
        assertEquals( "is equal to <5>", is(equalTo(5)).describe().toString());
    }
}