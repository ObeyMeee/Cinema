package ua.com.andromeda.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "movie_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @NotEmpty(message = "description can't be empty")
    private String description;
    @Min(value = 0, message = "duration can't be less than 0")
    private Integer duration;

    @Column
    @NotEmpty(message = "please, input director")
    private String director;

    @Column
    @NotEmpty(message = "please, input actors")
    private String actors;

    @Column
    @NotEmpty(message = "please, input genres")
    private String genres;

    @Column
    @NotEmpty(message = "please, input countries")
    private String countries;

    @Column
    @Min(value = 0, message = "year can't be a negative number")
    private Integer year;

    @OneToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "movieDetails")
    @ToString.Exclude
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "media_id")
    private Media media;

}
