package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.pwroblew.javapurefun.hascremt.Matchers.combine;
import static org.pwroblew.javapurefun.hascremt.StringDescription.from;

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

    default Matcher<T> mapDescription(Function<Tuple2<T,String>,String> descriptionMap, Function<Tuple2<T,String>,String> explanationMap) {
        return t -> this.match(t)
                .map(b -> b, desc -> from(descriptionMap.apply(Tuple.of(t,desc.describe())), explanationMap.apply(Tuple.of(t,desc.explain()))));
    }

    default Matcher<T> descriptionPrefix(String prefix) {
        return mapDescription( desc -> prefix + " " + desc._2(), expl -> prefix + " of <" + expl._1() + "> " + expl._2());
    }
}
