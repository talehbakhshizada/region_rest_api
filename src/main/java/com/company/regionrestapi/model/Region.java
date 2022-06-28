package com.company.regionrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    private String id; // mongodb
    private  String name;
    private Date createdDate = new Date();

}
