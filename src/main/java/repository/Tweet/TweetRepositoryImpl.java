package repository.Tweet;

import base.repository.impl.BaseRepositoryImpl;
import entity.tweet.Tweet;
import jakarta.persistence.EntityManager;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Tweet> implements TweetRepository{
    public TweetRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Tweet> getEntityClass() {
        return Tweet.class;
    }
}
