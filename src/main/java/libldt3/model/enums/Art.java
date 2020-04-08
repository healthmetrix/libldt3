package libldt3.model.enums;

/**
 * E016
 */
public enum Art {
    /** Keim */
    Keim("1"),
    /** Pilz */
    Pilz("2");

    private final String code;

    Art(String code) { this.code = code; }

    public String getCode() {
        return code;
    }
}
