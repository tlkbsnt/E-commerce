package fr.bsnt.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;
    @NonNull
    private String email;
    @NonNull
    private Long contact;

}
