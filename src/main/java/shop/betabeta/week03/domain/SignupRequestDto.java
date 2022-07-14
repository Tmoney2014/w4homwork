package shop.betabeta.week03.domain;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
public class SignupRequestDto {
    @Size(min = 3)
    @Pattern(regexp="[a-zA-Z0-9]", message = "아이디는 최소 3자 이상, 영문과 숫자로만 조합해주세요.")
    private String username;
    @Size(min = 4)
    private String password;
    private String password2;
    private String email;
    private boolean admin = false;
    private String adminToken = "";

    public boolean isContainIdInPw() { return password.contains(username); }
}