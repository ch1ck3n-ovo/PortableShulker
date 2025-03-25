package tw.ch1ck3n.portableshulker.enums;

public enum ClickType {

    NULL,
    LEFT_CLICK_ALL,
    LEFT_CLICK_AIR,
    LEFT_CLICK_BLOCK,
    RIGHT_CLICK_ALL,
    RIGHT_CLICK_AIR,
    RIGHT_CLICK_BLOCK;

    ClickType() {
    }

    public static ClickType get(String action) {
        if (action == null) return ClickType.NULL;
        try {
            return ClickType.valueOf(action.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ClickType.NULL;
        }
    }

    public static boolean isNull(ClickType action) {
        return action == NULL;
    }
}
