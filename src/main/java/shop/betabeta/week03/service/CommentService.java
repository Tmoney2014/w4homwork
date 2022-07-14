package shop.betabeta.week03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.betabeta.week03.domain.Comment;
import shop.betabeta.week03.domain.CommentRepository;
import shop.betabeta.week03.domain.CommentRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;


    @Transactional
    public Long updatecomment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID not found")
        );
        comment.updatecomment(commentRequestDto);
        return comment.getId();
    }

}