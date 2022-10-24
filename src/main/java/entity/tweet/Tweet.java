package entity.tweet;

import base.entity.BaseEntity;
import entity.comment.Comment;
import entity.like.Like;
import entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Tweet extends BaseEntity {

    @Column(length = 280)
    private String message;
    @OneToMany(mappedBy = "tweet")
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "tweet")
    @ToString.Exclude
    private List<Like> likes = new ArrayList<>();

    public Tweet(String message) {
        this.message = message;
    }

    public Tweet(User user) {
        this.user = user;
    }
}
