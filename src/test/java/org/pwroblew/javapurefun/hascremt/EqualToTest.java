package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;
import static org.pwroblew.javapurefun.hascremt.Matchers.rmap;
import static org.pwroblew.javapurefun.hascremt.MatchesAll.matchesAll;

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

    static class Tmp {
        private final int size;
        private final List<String> list;

        public Tmp(int size, List<String> list) {
            this.size = size;
            this.list = list;
        }

        public int size() {
            return size;
        }

        public List<String> list() {
            return list;
        }
    }
    @Test
    void testFlatMap() {
        final Tmp actualValid = new Tmp(6, asList("a", "b", "c", "d", "e", "f"));
        final Matcher<Tmp> tmpMatcher = matchesAll(Tmp.class)
                .flatRMap(obj -> rmap(x -> x.list().size(), equalTo(obj.size())));

        final Tuple2<Boolean, Description> matchResult = tmpMatcher.match(actualValid);
        assertEquals( true, matchResult._1());
    }

    @Test
    void testFlatMap_2() {
        final Tmp actualValid = new Tmp(6, asList("a", "b", "c", "d", "e", "f", "g"));
        final Matcher<Tmp> tmpMatcher = matchesAll(Tmp.class)
                .flatRMap(obj -> rmap(x -> x.list().size(), equalTo(obj.size())));

        final Tuple2<Boolean, Description> matchResult = tmpMatcher.match(actualValid);
        assertEquals( false, matchResult._1());
    }
}