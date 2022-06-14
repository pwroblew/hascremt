package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.pwroblew.javapurefun.hascremt.Matchers.combine;

@FunctionalInterface
public interface Matcher<T> extends Predicate<T> {
    Tuple2<Boolean, Description> match(T actual);

    @Override
    default boolean test(T t) {
        return this.match(t)._1();
    }

    default Matcher<T> flatRMap(Function<T, Matcher<T>> fun) {
        return x -> combine(this.match(x), fun.apply(x).match(x));
    }
}
