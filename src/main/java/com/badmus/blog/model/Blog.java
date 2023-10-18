package com.badmus.blog.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

import static jakarta.persistence.GenerationType.AUTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    private String uniqueId;

    private String title;

    private String description;

    private String url;

    private Date dateCreated;
}
