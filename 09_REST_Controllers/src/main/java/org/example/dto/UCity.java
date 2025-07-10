package org.example.dto;

public class UCity {
    private String name;
    private String code;

    public UCity() {
    }

    public UCity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "uCity{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
