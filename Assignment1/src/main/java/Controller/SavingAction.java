package Controller;

public enum SavingAction {
    TRANSFER("계좌이체"),
    DEPOSIT("입금"),
    WITHDRAW("출금");
    private final String action;

    SavingAction(String action) {
        this.action = action;
    }
    public String getAction() {
        return action;
    }
    public static SavingAction findByAction(String action) {
        for (SavingAction value : values()) {
            if (value.getAction().equalsIgnoreCase(action)) {
                return value;
            }
        }
        return null;
    }
}
