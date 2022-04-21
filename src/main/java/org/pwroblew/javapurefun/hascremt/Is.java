package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import static org.pwroblew.javapurefun.hascremt.StringDescription.from;

public class Is<T> implements Matcher<T> {

    private final Matcher<T> matcher;

    private Is(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    static public <V> Is<V> is(Matcher<V> it) {
        return new Is<>(it);
    }

    @Override
    public Tuple2<Boolean, Description> match(T actual) {
        return matcher.match(actual).map((a, b) -> Tuple.of(a, from("is " + b.toString())));
    }

    @Override
    public Description describe() {
        return from("is " + matcher.describe().toString());
    }
}
