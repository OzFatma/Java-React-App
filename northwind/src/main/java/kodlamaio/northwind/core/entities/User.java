package kodlamaio.northwind.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //veritabanına göre değişir identity olduğunu bildirdik.
    @Column(name = "id")
    private int id;

    @Email
    @NotBlank
    @NotNull
    @Column(name = "email")
    private String email;

    @NotBlank
    @NotNull
    @Column(name = "password")
    private String password;

}
