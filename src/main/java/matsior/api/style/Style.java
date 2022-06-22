package matsior.api.style;

public enum Style {
    PALE_LAGER("Pale Lager"),
    DORTMUNDER_EXPORT("Dortmunder Export"),
    WITBIER("Witbier"),
    ALE("Ale"),
    LAGER("Lager");

    private final String name;

    Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
