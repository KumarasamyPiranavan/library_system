package com.piranavan.lbmsusb_bend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Customer customerId;

    @ManyToOne
    private Book bookId;

    private boolean isReturned;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date issueDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date returnDate;

}
