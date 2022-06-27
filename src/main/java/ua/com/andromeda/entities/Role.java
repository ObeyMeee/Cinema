package ua.com.andromeda.entities;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Entity
@Table(name = "roles")
@Getter
public enum Role implements Serializable {
    OWNER, SUPER_ADMIN, ADMIN, CUSTOMER;
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    @NotEmpty(message = "name can't be empty")
    private String name;

}
