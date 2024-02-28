package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private  static Map<Long, Member> store = new HashMap<>();

    //순서 0,1,2
    private  static  long sequence = 0L;

    @Override
    public Member save(Member member) {
        //하나 올려주고 store에 pyt
        member.setId(++sequence);
        store.put(member.getId(), member);
        return  member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        
        //null이 있을 가능성이 있으면 optional로 감싼다 (null이어도 감쌀수 있게됨)
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return   store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
}
