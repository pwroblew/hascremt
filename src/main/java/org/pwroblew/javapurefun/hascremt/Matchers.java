package org.pwroblew.javapurefun.hascremt;

import java.util.function.Function;

public class Matchers {
    public static <T,V> Matcher<V> rmap(Function<V, T> function, Matcher<T> theMatcher) {
        return actual -> theMatcher.match(function.apply(actual));
    }
}
