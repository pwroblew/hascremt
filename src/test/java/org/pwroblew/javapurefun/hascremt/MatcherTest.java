package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.pwroblew.javapurefun.hascremt.EqualTo.equalTo;
import static org.pwroblew.javapurefun.hascremt.Matchers.rmap;
import static org.pwroblew.javapurefun.hascremt.MatchesAll.matchesAll;

class MatcherTest {


    static class TmpEntity {
        private final int size;
        private final List<String> list;

        public TmpEntity(int size, List<String> list) {
            this.size = size;
            this.list = list;
        }

        public int size() {
            return size;
        }

        public List<String> list() {
            return list;
        }

        @Override
        public String toString() {
            return "TmpEntity{" +
                    "size=" + size +
                    ", list=" + list +
                    '}';
        }
    }
    @Test
    void testFlatRMap() {
        final TmpEntity actualValid = new TmpEntity(6, asList("a", "b", "c", "d", "e", "f"));

        final Matcher<TmpEntity> tmpMatcher = matchesAll(TmpEntity.class)
                .flatRMap(obj -> rmap((TmpEntity x) -> x.list().size(), equalTo(obj.size()).prefixParam("TmpEntity.size=")).descriptionPrefix("TmpEntity.list.size"));

        final Tuple2<Boolean, Description> matchResult = tmpMatcher.match(actualValid);

        assertEquals( true, matchResult._1());
        assertEquals( "(any of type [TmpEntity]) AND (TmpEntity.list.size equal to TmpEntity.size=<6>)", matchResult._2().describe());
        assertEquals( "(TmpEntity) AND (TmpEntity.list.size of <" + actualValid + "> equal to <6>)", matchResult._2().explain());
    }

    @Test
    void testFlatRMap_2() {
        final TmpEntity actualValid = new TmpEntity(6, asList("a", "b", "c", "d", "e", "f", "g"));
        final Matcher<TmpEntity> tmpMatcher = matchesAll(TmpEntity.class)
                .flatRMap(obj -> rmap((TmpEntity x) -> x.list().size(), equalTo(obj.size())).descriptionPrefix("TmpEntity->list->size"));

        final Tuple2<Boolean, Description> matchResult = tmpMatcher.match(actualValid);
        assertEquals( false, matchResult._1());
        assertEquals( "(any of type [TmpEntity]) AND (TmpEntity->list->size equal to <6>)", matchResult._2().describe());
        assertEquals( "(TmpEntity) AND (TmpEntity->list->size of <" + actualValid + "> equal to <7>)", matchResult._2().explain());
    }
}