package shop.betabeta.week03.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shop.betabeta.week03.domain.Memo;
import shop.betabeta.week03.domain.MemoRepository;
import shop.betabeta.week03.domain.MemoRequestDto;
import shop.betabeta.week03.service.MemoService;
import sun.security.util.Password;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Optional<Memo> memo = memoRepository.findById(id);
        if (memo.isPresent()) {
            if (memo.get().getPassword().equals(requestDto.getPassword())) {
                memoRepository.deleteById(id);
            } else {
                System.out.println("비밀번호 불일치");
            }

        }
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Optional<Memo> memo = memoRepository.findById(id);
        if (memo.isPresent()) {
            if (memo.get().getPassword().equals(requestDto.getPassword())) {
                memoService.update(id, requestDto);
            } else {
                System.out.println("비밀번호 오류");
            }

        }

        return id;

    }

}

