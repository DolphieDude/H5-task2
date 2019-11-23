package com.cherevatyi;

public class Human {
    public static final String DF_NAME = "Noname", DF_CITY = "Homeless";
    public static final int DF_AGE = 2;

    private String name, city;
    private int age;

    Human () {
        this.name = DF_NAME;
        this.city = DF_CITY;
        this.age = DF_AGE;
    }
    Human (String inName, String inCity, int inAge) {
        this.name = inName;
        this.city = inCity;
        if (inAge > 0) this.age = inAge;
        else this.age = DF_AGE;
    }

    @Override
    public String toString() {
        return new StringBuilder("name = ").append(this.name)
                .append("; city = ").append(this.city)
                .append("; age = ").append(this.age)
                .append(";").toString();
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public int getAge() { return age; }
}
