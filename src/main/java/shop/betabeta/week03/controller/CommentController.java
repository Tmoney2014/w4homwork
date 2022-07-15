package shop.betabeta.week03.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import shop.betabeta.week03.domain.Comment;
import shop.betabeta.week03.domain.CommentRepository;
import shop.betabeta.week03.domain.CommentRequestDto;

import shop.betabeta.week03.service.CommentService;

import javax.persistence.Id;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    // 메모 아이디를 여기서 갖고 와야 하는건가 ?? 포스팅할때 리턴으로 메모 아이디를 줘야하나 ?
    @PostMapping("/api/comments/{memoid}")
    public Comment createComment(@PathVariable Long memoid, @RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = new Comment(commentRequestDto, memoid);
        return commentRepository.save(comment);
    }
    @GetMapping("/api/comment/{memoid}")
    public List<Comment> getComment(@PathVariable Long memoid) {
        return commentRepository.findAllByMemoidOrderByModifiedAtDesc(memoid);

    }
//로그인을 하지 않으면 애초에 API 에 접근이 불가능 하지만, 만약 로그인을 하고 사람의 코멘트ID를 URL에 직접 입력하여
//다른 사람의 코멘트를 수정할수 있지는 않을까 ?
    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updatecomment(id, commentRequestDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
