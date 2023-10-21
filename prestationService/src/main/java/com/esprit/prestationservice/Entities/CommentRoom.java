package com.esprit.prestationservice.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRoom implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idComment;
    @Temporal(TemporalType.DATE)
    private Date dateCreationComment;
    private String descriptionComment;
    private String commentUserId;

    @JsonIgnore
    @ManyToOne
    private Room room;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}
