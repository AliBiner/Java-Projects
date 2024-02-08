package com.elasticsearch.elasticlombok.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
@Getter
@Setter
@Document(indexName = "user")
@ToString
@NoArgsConstructor
public class UserLombok {
    private String id;
    private String name;
    private String surname;
    private String address;
    private Date birthDate;
}
