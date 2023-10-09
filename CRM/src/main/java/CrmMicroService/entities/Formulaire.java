package CrmMicroService.entities;

import CrmMicroService.entities.enums.ServiceType;
import CrmMicroService.entities.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode

public class Formulaire implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;

	@Enumerated (EnumType.STRING)
	private ServiceType service;

	@Enumerated(EnumType.STRING)
	private Status status = Status.OUVERT;

	private LocalDateTime date = LocalDateTime.now();

	// Constructeurs, getters et setters


}
