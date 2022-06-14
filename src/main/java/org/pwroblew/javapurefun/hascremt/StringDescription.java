package org.pwroblew.javapurefun.hascremt;

public class StringDescription implements Description {
    private final String description;
    private final String explanation;

    private StringDescription(String description, String explanation) {
        this.description = description;
        this.explanation = explanation;
    }

    static public StringDescription from(String _description, String _explanation) {
        return new StringDescription(_description, _explanation);
    }

    @Override
    public String describe() {
        return description;
    }

    @Override
    public String explain() {
        return explanation;
    }
}
