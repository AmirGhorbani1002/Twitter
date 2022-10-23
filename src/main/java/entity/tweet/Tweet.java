package entity.tweet;

import base.entity.BaseEntity;
import entity.comment.Comment;
import entity.user.User;
import entity.like.Like;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Tweet extends BaseEntity {

    @Column(length = 280)
    private String twit;
    @OneToMany(mappedBy = "tweet")
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "tweet")
    @ToString.Exclude
    private Set<Like> likes;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    public Tweet(User user) {
        this.user = user;
    }
}
