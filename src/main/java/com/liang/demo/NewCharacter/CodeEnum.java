package com.liang.demo.NewCharacter;

/**
 * @author Li Yang
 * @date 2021/10/29
 * 定义枚举类
 */
public enum CodeEnum {

    SPRING(1, "春天"),

    SUMMER(2, "夏天"),

    AUTUMN(3, "秋天"),

    WINTER(4, "冬天"),
    ;

    private final String desc;

    private final Integer code;

    CodeEnum(Integer code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }
}
