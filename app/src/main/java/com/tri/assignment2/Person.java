package com.tri.assignment2;

public class Person {
    private String name;
    private String number;
    private Boolean gender;
    private String level;
    private Integer age;
    private Boolean doesSport;
    private String hobby;

    public Person(String name, String number, Boolean gender, String level, Integer age, Boolean doesSport, String hobby) {
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.level = level;
        this.age = age;
        this.doesSport = doesSport;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return String.format("Person{ Tên = %s, SĐT = %s, Giới tính = %s, Trình độ = %s, Tuổi = %s, Thể thao = %s, Sở thích = %s }",
                name,
                number,
                gender ? "Nữ" : "Nam",
                level,
                age,
                doesSport ? "Có" : "Không",
                hobby);
    }
}
