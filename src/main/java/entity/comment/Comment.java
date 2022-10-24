package entity.comment;

import base.entity.BaseEntity;
import entity.like.Like;
import entity.tweet.Tweet;
import entity.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Comment extends BaseEntity {

    private String message;
    @OneToOne
    private Comment comment;
    @ManyToOne
    private Tweet tweet;
    @OneToMany(mappedBy = "comment")
    private List<Like> likes = new ArrayList<>();
    @ManyToOne
    private User user;

}
