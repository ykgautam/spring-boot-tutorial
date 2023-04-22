package com.yash.springboot.tutorial.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "please add department name")
    /* other examples of annotations
    @Length(max = 10, min = 1)
    @Size(max = 15, min = 1)
    @Positive
    @Negative
    @Email
    @PositiveOrZero
    @NegativeOrZero
    @Future // for date fiels
    @Past
    @PastOrPresent
    @FutureOrPresent*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
