package community_health_management.enums;

public enum Role {
    ADMIN(0,"管理员"),
    STAFF(1,"普通职员"),
    CAPTAIN(2,"队长");

    private Integer code;
    private String text;

    Role(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }
    public static Integer getCode(String text) {
        for (Role role : Role.values()) {
            if (role.getText().equals(text)) {
                return role.getCode();
            }
        }
        return null;
    }

    public String getText() {
        return text;
    }
    public static String getText(Integer code) {
        for (Role role : Role.values()) {
            if (role.getCode().equals(code)) {
                return role.getText();
            }
        }
        return null;
    }
}
