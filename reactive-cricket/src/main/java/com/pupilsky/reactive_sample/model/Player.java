package com.pupilsky.reactive_sample.model;

public class Player {
    public Player(String name, String country) {
                    super();
                    this.name = name;
                    this.country = country;
            }
            String name;
    String country;
            public String getName() {
                    return name;
            }
            public void setName(String name) {
                    this.name = name;
            }
            
            
            public String getCountry() {
                    return country;
            }
            public void setCountry(String country) {
                    this.country = country;
            }
            @Override
            public String toString() {
                    return "name :-"+name+" country:-"+country;
            }
    
}
