package service.follow.impl;

import base.service.impl.BaseServiceImpl;
import entity.follow.Follow;
import repository.follow.FollowRepository;
import service.follow.FollowService;

import java.util.List;

public class FollowServiceImpl extends BaseServiceImpl<Follow, FollowRepository> implements FollowService {
    public FollowServiceImpl(FollowRepository repository) {
        super(repository);
    }


    @Override
    public List<String> showFollowers(Long id) {
        return repository.showFollowers(id);
    }

    @Override
    public List<String> showFollowing(Long id) {
        return repository.showFollowing(id);
    }
}
