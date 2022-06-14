package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;

class EqualToTest {

    @Test
    void testEqualToFivePasses() {
        Tuple2<Boolean, Description> matchResult = equalTo(5).match(5);
        assertEquals( true, matchResult._1());
        assertEquals( "equal to <5>", matchResult._2().describe());
        assertEquals( "equal to <5>", matchResult._2().explain());
    }

    @Test
    void testEqualToFiveFails() {
        var matchResult = equalTo(5).match(6);
        assertEquals(false, matchResult._1());
        assertEquals( "equal to <5>", matchResult._2().describe());
        assertEquals( "equal to <6>", matchResult._2().explain());
    }
}