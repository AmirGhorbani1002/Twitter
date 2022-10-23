package service.comment.impl;

import base.service.impl.BaseServiceImpl;
import entity.comment.Comment;
import repository.comment.CommentRepository;
import service.comment.CommentService;

public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentRepository> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }
}
