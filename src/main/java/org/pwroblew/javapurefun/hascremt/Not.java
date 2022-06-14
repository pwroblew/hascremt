package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import static org.pwroblew.javapurefun.hascremt.StringDescription.from;

public class Not<T> implements Matcher<T> {
    @Override
    public Tuple2<Boolean, Description> match(T actual) {
        return matcher.match(actual).map((a, b) -> Tuple.of(!a, from("not " + b.describe(), b.explain())));
    }

    private final Matcher<T> matcher;

    private Not(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    static public <V> Not<V> not(Matcher<V> it) {
        return new Not<>(it);
    }

}

