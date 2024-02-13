package com.pizzaTest.repository;

import com.pizzaTest.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setUserId(++sequence);
        member.setUuid(UUID.randomUUID());
        store.put(member.getUserId(), member);
        return member;
    }

    @Override
    public Member findById(Long userId) {
        return store.get(userId);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearMember(){
        store.clear();
    }
}