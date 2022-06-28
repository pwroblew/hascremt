package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import static org.pwroblew.javapurefun.hascremt.StringDescription.from;

public class MatchesAll<T> implements Matcher<T> {
    private final Class<T> clazz;

    public MatchesAll(Class<T> clazz) {
        this.clazz = clazz;
    }

    static public <V> Matcher<V> matchesAll(Class<V> clazz) {
        return new MatchesAll<>(clazz);
    }

    @Override
    public Tuple2<Boolean, Description> match(T actual) {
        return Tuple.of(Boolean.TRUE, from("any of type [" + clazz.getSimpleName() + "]" , clazz.getSimpleName()));
    }

}