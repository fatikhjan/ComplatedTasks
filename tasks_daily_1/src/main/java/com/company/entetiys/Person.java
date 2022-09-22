package com.company.entetiys;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String region;
    private String imageUrl;
}
