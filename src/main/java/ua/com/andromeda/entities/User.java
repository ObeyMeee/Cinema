package ua.com.andromeda.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @Email(message = "Invalid email")
    private String email;

    @Column
    @NotEmpty(message = "login cannot be empty")
    @Size(min = 2, max = 50, message = "login should contains more than 2 and less than 50 characters")
    private String login;

    @Column
    @NotEmpty(message = "password cannot be empty")
    @Size(min = 5, max = 50, message = "password should contains more than 5 and less than 50 characters")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private Ticket ticket;
}
