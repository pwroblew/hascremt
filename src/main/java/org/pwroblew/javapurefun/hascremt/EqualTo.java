package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import static org.pwroblew.javapurefun.hascremt.StringDescription.from;

public class EqualTo<T> implements Matcher<T> {

    private final T it;

    private EqualTo(T it) {
        this.it = it;
    }

    static public <V> EqualTo<V> equalTo(V it) {
        return new EqualTo<>(it);
    }

    @Override
    public Tuple2<Boolean, Description> match(T actual) {
        return Tuple.of(it.equals(actual), from( "equal to <" + it + ">", "equal to <" + actual + ">"));
    }

    public Matcher<T> prefixParam(String prefix) {
        return mapDescription(desc -> desc._2().replaceAll("<(\\d+)>", prefix + "<$1>"), expl -> expl._2());
    }
}