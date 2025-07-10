package org.example.dto;

public class UserDto {
    private String userId;
    private String userName;
    private String address;
    private UCity uCity;

    public UserDto() {
    }

    public UserDto(String userId, String userName, String address, UCity uCity) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.uCity = uCity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UCity getuCity() {
        return uCity;
    }

    public void setuCity(UCity uCity) {
        this.uCity = uCity;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", uCity=" + uCity +
                '}';
    }
}
