package org.pwroblew.javapurefun.hascremt;

import io.vavr.Tuple2;

public class MatcherAssert {

    public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
        Tuple2<Boolean, Description> matchResult = matcher.match(actual);
        if (!matchResult._1()) {
            StringBuilder stringBuilder = new StringBuilder()
                    .append("\nExpected: ")
                    .append(matcher.describe().toString())
                    .append("\n  Actual: ")
                    .append(matchResult._2().toString());

            throw new AssertionError(stringBuilder.toString());
        }


    }

}
