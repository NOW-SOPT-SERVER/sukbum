package Controller;

public enum MainAction {
    JOIN_BANK("은행가입"),
    SAVINGS("예적금"),
    SHOW_ALL_ACCOUNTS("전체계좌조회"),
    EXIT("나가기");

    private final String action;

    MainAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public static MainAction findByAction(String action) {
        for (MainAction value : values()) {
            if (value.getAction().equalsIgnoreCase(action)) {
                return value;
            }
        }
        return null;
    }
}
