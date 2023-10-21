package com.example.paymentms.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRoom {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idComment;
    @Temporal(TemporalType.DATE)
    private Date dateCreationComment;
    private String descriptionComment;

    @JsonIgnore
    @ManyToOne
    private Room room;

    @JsonIgnoreProperties(value = {"commentList"})
    @ManyToOne
    private User user;

}
