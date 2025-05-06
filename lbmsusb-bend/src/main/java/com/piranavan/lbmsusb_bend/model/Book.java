package com.piranavan.lbmsusb_bend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String id;
    private String title;
    private String part;
    private String category;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date storedDate;
    private String author;
    private String publication;
    private int availableCopies;
}
