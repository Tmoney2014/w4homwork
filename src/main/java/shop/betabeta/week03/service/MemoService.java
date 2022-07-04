package shop.betabeta.week03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.betabeta.week03.domain.Memo;
import shop.betabeta.week03.domain.MemoRepository;
import shop.betabeta.week03.domain.MemoRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();  //id
    }
}
