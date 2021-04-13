package com.vasudha.springdataredis.model;


import lombok.*;

import java.io.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Programmer implements Serializable {
    private int id;
    private String name;
    private String company;
}
