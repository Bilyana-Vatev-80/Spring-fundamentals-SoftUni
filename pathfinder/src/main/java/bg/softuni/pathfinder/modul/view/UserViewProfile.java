package bg.softuni.pathfinder.modul.view;

import bg.softuni.pathfinder.modul.entity.enums.LevelEnum;

public class UserViewProfile {

    private Long id;
    private String fullName;
    private String username;
    private Integer age;
    private LevelEnum level;

    public UserViewProfile() {
    }

    public Long getId() {
        return id;
    }

    public UserViewProfile setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserViewProfile setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewProfile setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserViewProfile setAge(Integer age) {
        this.age = age;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserViewProfile setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}
