package hex.music.core.domain;

/**
 *
 * @author hln
 */
public interface Clef extends DomainEntity {

    public static final int DEFAULT_TRANSPOSE = 0;
    public static final String DEFAULT_MIDDLE = "B";
    public static final Type DEFAULT_TYPE = Type.TREBLE;

    Type getType();

    void setType(Type type);

    int getTranspose();

    void setTranspose(int transpose);

    /**
     * Returns the note representation that is used on the middle (third) line.
     *
     * Defaults are: treble: B; alto: C; tenor: A,; bass: D,; none: B
     * 
     * i.e clef=bass middle=d means that the D, is noted as d in the body.
     *
     * @return
     */
    String getMiddle();

    /**
     * Sets the note representation that is used on the middle (third) line.
     *
     * Defaults are: treble: B; alto: C; tenor: A,; bass: D,; none: B
     *
     * i.e clef=bass middle=d means that the D, is noted as d in the body.
     *
     * @param middle
     */
    void setMiddle(String middle);

    public enum Type {

        TREBLE("G-klav", "treble"),
        ALTO("C- eller Altklav", "alto"),
        BASS("Basklav", "bass"),
        TREBLE_8VA("G-klav 8va", "treble+8"),
        TREBLE_8VA_BASSO("G-klav 8va basso", "treble-8"),
        BASS_8VA("Basklav 8va", "bass+8"),
        BASS_8VA_BASSO("Bas-kla 8va basso", "bass-8"),
        TREBLE1("G-klav, linje 1", "treble1"),
        TREBLE2("G-klav, linje 2", "treble2"),
        TREBLE3("G-klav, linje 3", "treble3"),
        TREBLE4("G-klav, linje 4", "treble4"),
        TREBLE5("G-klav, linje 5", "treble5"),
        ALTO1("C-klav, linje 1 (Sopranklav)", "alto1"),
        ALTO2("C-klav, linje 2 (Mezzosopranklav)", "alto2"),
        ALTO3("C-klav, linje 3 (Altklav)", "alto3"),
        ALTO4("C-klav, linje 4 (Tenorklav)", "alto4"),
        ALTO5("C-klav, linje 5 (Baritonklav)", "alto5"),
        BASS1("Basklav, linje 1", "bass1"),
        BASS2("Basklav, linje 2", "bass2"),
        BASS3("Basklav, linje 3", "bass3"),
        BASS4("Basklav, linje 4", "bass4"),
        BASS5("Basklav, linje 5", "bass5"),
        TENOR("C-klav, linje 4", "tenor"),
        SOPRANO("C-klav, linje 1", "alto1"),
        MEZZOSOPRANO("C-klav, linje 2", "alto2"),
        BARITON("Basklav, linje 3 (Baritonklav)", "bass3");
        private final String label;
        private final String code;

        private Type(String label, String code) {
            this.label = label;
            this.code = code;

        }

        public String getLabel() {
            return label;
        }

        public String getCode() {
            return code;
        }

        public static Type getByCode(String code) {
            for (Type t : values()) {
                if (t.getCode().equalsIgnoreCase(code)) {
                    return t;
                }
            }
            return DEFAULT_TYPE;
        }

        public static Type getByString(String typeString) {
            for (Type t : values()) {
                if (t.getLabel().equals(typeString)) {
                    return t;
                }
            }
            return getByCode(typeString);
        }
    }
}
