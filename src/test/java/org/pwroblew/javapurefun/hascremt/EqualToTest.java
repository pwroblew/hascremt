package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;
import org.junit.jupiter.api.Test;

import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;
import static org.pwroblew.javapurefun.hascremt.Is.is;
import static org.pwroblew.javapurefun.hascremt.MatcherAssert.assertThat;
import static org.pwroblew.javapurefun.hascremt.Not.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualToTest {

    @Test
    void testEqualToFivePasses() {
        Tuple2<Boolean, Description> matchResult = equalTo(5).match(5);
        assertEquals( true, matchResult._1());
        assertEquals("equal to <5>", matchResult._2().toString());
    }

    @Test
    void testEqualToFiveFails() {
        var matchResult = equalTo(5).match(6);
        assertEquals(false, matchResult._1());
        assertEquals( "equal to <6>", matchResult._2().toString());
    }

    @Test
    void testDescribe() {
        var equalToFiveDescription = equalTo(5).describe().toString();
        assertEquals( "equal to <5>", equalToFiveDescription);
    }
}