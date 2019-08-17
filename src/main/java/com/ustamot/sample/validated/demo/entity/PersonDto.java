package com.ustamot.sample.validated.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto {

    @NotNull
    private String name;

    @NotNull
    @Digits(integer=2, fraction=0)
    private String age;

    private String zipcode;
}
