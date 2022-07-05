package shop.betabeta.week03.domain;

import lombok.Getter;
import sun.security.util.Password;

@Getter
public class MemoRequestDto {
    private String title;
    private String username;
    private String contents;
    private Long password;
}
