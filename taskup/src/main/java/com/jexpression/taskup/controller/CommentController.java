package com.jexpression.taskup.controller;

import com.jexpression.taskup.model.Comment;
import com.jexpression.taskup.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Get comments for a specific task
    @GetMapping("/tasks/{taskId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByTask(@PathVariable Long taskId) {
        List<Comment> comments = commentService.getCommentsByTaskId(taskId);
        return ResponseEntity.ok(comments);
    }

    // Add a new comment to a task
    @PostMapping("/tasks/{taskId}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long taskId,@Valid @RequestBody Comment comment) {
        Comment createdComment = commentService.addComment(taskId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    // Delete a comment by ID
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

}
