package org.pwroblew.javapurefun.hascremt;

public class StringDescription implements Description {
    private final String description;

    private StringDescription(String description) {
        this.description = description;
    }

    static public StringDescription from(String description) {
        return new StringDescription(description);
    }

    @Override
    public String toString() {
        return description;
    }
}
