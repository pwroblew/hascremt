package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.util.function.Function;

import static org.pwroblew.javapurefun.hascremt.StringDescription.from;

public class Matchers {
    public static <T,V> Matcher<V> rmap(Function<V, T> function, Matcher<T> theMatcher) {
        return actual -> theMatcher.match(function.apply(actual));
    }

    public static Tuple2<Boolean, Description> combine(Tuple2<Boolean, Description> match1, Tuple2<Boolean, Description> match2) {
        return Tuple.of(
                match1._1() && match2._1(),
                from(
                        "(" + match1._2().describe() + ") AND (" + match2._2().describe() + ")",
                        "(" + match1._2().explain() + ") AND (" + match2._2().explain() + ")"));
    }
}
