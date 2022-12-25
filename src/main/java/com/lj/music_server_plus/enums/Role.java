package com.lj.music_server_plus.enums;

public enum Role {
    ADMIN(1,"管理员"),
    USER(0,"用户");

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
