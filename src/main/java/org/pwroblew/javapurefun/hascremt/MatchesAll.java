package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import static org.pwroblew.javapurefun.hascremt.StringDescription.from;

public class MatchesAll<T> implements Matcher<T> {


    static public <V> Matcher<V> matchesAll(Class<V> tmpClass) {
        return new MatchesAll<>();
    }

    @Override
    public Tuple2<Boolean, Description> match(T actual) {
        return Tuple.of(Boolean.TRUE, from("ALL", "ALL"));
    }

}