package repository.followRepository;

import base.repository.impl.BaseRepositoryImpl;
import entity.follow.Follow;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FollowRepositoryImpl extends BaseRepositoryImpl<Follow> implements FollowRepository{


    public FollowRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Follow> getEntityClass() {
        return Follow.class;
    }

    @Override
    public List<String> showFollowers(Long id) {
        return em.createQuery("select f.follower.username from Follow f where f.following.id = :id", String.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<String> showFollowing(Long id) {
        return em.createQuery("select f.following.username from Follow f where f.follower.id = :id", String.class)
                .setParameter("id", id)
                .getResultList();
    }
}
