package repository.Like;

import base.repository.impl.BaseRepositoryImpl;
import entity.like.Like;
import entity.tweet.Tweet;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LikeRepositoryImpl extends BaseRepositoryImpl<Like> implements LikeRepository{
    public LikeRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Like> getEntityClass() {
        return Like.class;
    }

    @Override
    public List<String> findLikedAccounts(Tweet tweet) {
        return em.createQuery("select l.user.username from Like l where l.tweet.id = :input", String.class)
                .setParameter("input", tweet.getId())
                .getResultList();
    }
}
