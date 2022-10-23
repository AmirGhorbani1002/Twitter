package repository.comment.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.comment.Comment;
import jakarta.persistence.EntityManager;
import repository.comment.CommentRepository;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment> implements CommentRepository {

    public CommentRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
