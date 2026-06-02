package emu.grasscutter.net.proto;

public enum GrantReason {
    GRANT_REASON_INVALID(0),
    GRANT_REASON_BY_QUEST(1),
    GRANT_REASON_BY_ACTIVITY(2),
    GRANT_REASON_BY_MAIL(3),
    GRANT_REASON_BY_TRIAL_AVATAR_ACTIVITY(21);

    private final int value;

    GrantReason(int value) {
        this.value = value;
    }

    public int getNumber() {
        return value;
    }

    public static GrantReason forNumber(int value) {
        for (GrantReason r : values()) {
            if (r.value == value) return r;
        }
        return GRANT_REASON_INVALID;
    }
}
