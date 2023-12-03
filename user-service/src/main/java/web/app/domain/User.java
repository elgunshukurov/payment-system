package web.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.userdetails.UserDetails;
//import web.app.domain.ManyToMany.Authority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = User.TABLE_NAME)
//@SuppressWarnings("PMD.TooManyFields")
public class User implements UserDetails {

    public static final String TABLE_NAME = "users";
    private static final long serialVersionUID = -345588320444257803L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(nullable = false)
    private String password;
    private String phone;

    @Column(nullable = false, unique = true)
    private String username;


    private String name;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @Column(updatable = false)
    private LocalDateTime creationDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
    }

}

