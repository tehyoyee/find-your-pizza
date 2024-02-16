//package com.pizzaTest.demo.repository.servey;
//
//import com.pizzaTest.demo.domain.Servey;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class MemoryServeyRepository implements ServeyRepository {
//    private static Map<Integer, Servey> serveyPage = new ConcurrentHashMap<>();
//    private static int sequence = 0;
//
//    @Override
//    public Servey save(Servey servey){
//        servey.setQuestionId(++sequence);
//        serveyPage.put(servey.getQuestionId(), servey);
//        return servey;
//    }
//
//    @Override
//    public Servey findById(int questionId) {
//        return serveyPage.get(questionId);
//    }
//
//    public void clearServey() {
//        serveyPage.clear();
//    }
//}
