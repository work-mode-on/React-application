package com.blog.application.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.application.entities.Comment;
import com.blog.application.entities.Post;
import com.blog.application.exceptions.ResourceNotFound;
import com.blog.application.payloads.CommentDto;
import com.blog.application.repositories.CommentRepository;
import com.blog.application.repositories.PostRepository;
import com.blog.application.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PostRepository postRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFound("Post", postId));
		Comment comment = this.mapper.map(commentDto, Comment.class);
		comment.setPost(post);
		comment.setContent(commentDto.getContent());
		return this.mapper.map(this.commentRepo.save(comment), CommentDto.class);
	}

	@Override
	public CommentDto updateComment(CommentDto commentDto, Integer commentId) {
		Comment oldComment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFound("Comment", commentId));
		oldComment.setContent(commentDto.getContent());
		Comment updatedComment = this.commentRepo.save(oldComment);
		return this.mapper.map(updatedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFound("Comment", commentId));
		this.commentRepo.delete(comment);
	}

}
