package tw.ch1ck3n.portableshulker.enums;

public enum SneakType {

    NULL,
    BOTH,
    NO_SNEAK,
    ONLY_SNEAK;

    SneakType() {
    }

    public static SneakType get(String action) {
        if (action == null) return SneakType.NULL;
        try {
            return SneakType.valueOf(action.toUpperCase());
        } catch (IllegalArgumentException e) {
            return SneakType.NULL;
        }
    }

    public static boolean isNull(SneakType action) {
        return action == NULL;
    }
}
