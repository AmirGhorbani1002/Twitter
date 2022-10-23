package entity.comment;

import base.entity.BaseEntity;
import entity.like.Like;
import entity.tweet.Tweet;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment extends BaseEntity {

    private String message;
    @OneToOne
    private Comment comment;
    @ManyToOne
    private Tweet tweet;
    @OneToMany(mappedBy = "comment")
    private List<Like> likes = new ArrayList<>();

}
