package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;
import java.util.function.Predicate;

@FunctionalInterface
public interface Matcher<T> extends Predicate<T> {
    Tuple2<Boolean, Description> match(T actual);

    @Override
    default boolean test(T t) {
        return this.match(t)._1();
    }
}
