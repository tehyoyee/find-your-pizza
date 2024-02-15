//package com.pizzaTest.demo.repository.member;
//
//import com.pizzaTest.demo.domain.Member;
//import com.pizzaTest.demo.repository.member.MemberRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class MemoryMemberRepository implements MemberRepository {
//    private static Map<Integer, Member> store = new ConcurrentHashMap<>();
//    private static int sequence = 0;
//
//    @Override
//    public Member save(Member member) {
//        member.setUserId(++sequence);
//        member.setUuid(UUID.randomUUID());
//        store.put(member.getUserId(), member);
//        return member;
//    }
//
//    @Override
//    public Member findById(int userId) {
//        return store.get(userId);
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    public void clearMember(){
//        store.clear();
//    }
//}