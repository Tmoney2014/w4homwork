package shop.betabeta.week03.domain;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity

public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 이 메모 아이디는 어디서 갖고 오는걸까 ?? 도대체 ??
    // 자동 생성도 아니고.. 그럼 어딘가에서 갖고 와야 하는데 .. 어디서 갖고 올수 있을까 ?
    @Column(nullable = false)
    private Long memoid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto commentRequestDto,Long memoid) {
        this.memoid = memoid;
        this.username = commentRequestDto.getUsername();
        this.comment = commentRequestDto.getComment();
    }

    public void updatecomment(CommentRequestDto commentRequestDto) {

        this.username = commentRequestDto.getUsername();
        this.comment = commentRequestDto.getComment();
    }
}