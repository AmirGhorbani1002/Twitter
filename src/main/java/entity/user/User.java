package entity.user;

import base.entity.BaseEntity;
import entity.follow.Follow;
import entity.like.Like;
import entity.tweet.Tweet;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String fullName;

    private String username;

    private String password;
    @OneToMany(mappedBy = "user")
    private Set<Like> likes;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Tweet> tweets;
    @OneToMany(mappedBy = "following")
    private Set<Follow> following;
    @OneToMany(mappedBy = "follower")
    private Set<Follow> follower;
    public User(String fullName, String username, String password) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }
}
