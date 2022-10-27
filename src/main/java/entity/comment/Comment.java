package entity.comment;

import base.entity.BaseEntity;
import entity.like.Like;
import entity.tweet.Tweet;
import entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseEntity {

    private String message;
    @OneToOne(cascade = CascadeType.ALL)
    private Comment comment;
    @ManyToOne(cascade = CascadeType.ALL)
    private Tweet tweet;
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();
    @ManyToOne
    private User user;

    public Comment(String message, Tweet tweet, User user) {
        this.message = message;
        this.tweet = tweet;
        this.user = user;
    }

    public Comment(String message, Comment comment, User user) {
        this.message = message;
        this.comment = comment;
        this.user = user;
    }
}
