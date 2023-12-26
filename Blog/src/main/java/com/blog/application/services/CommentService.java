package com.blog.application.services;

import com.blog.application.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	CommentDto updateComment(CommentDto commentDto, Integer commentId);
	
	void deleteComment(Integer commentId);

}
