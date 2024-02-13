package com.pizzaTest.demo.repository.result;

import com.pizzaTest.demo.domain.Result;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryResultRepository implements ResultRepository {
    private static Map<Integer, Result> resultPage = new ConcurrentHashMap<>();
    private static int sequence = 0;

    @Override
    public Result save(Result result) {
        result.setResultId(++sequence);
        resultPage.put(result.getResultId(), result);
        return result;
    }

    @Override
    public Result findById(int resultId) {
        return resultPage.get(resultId);
    }

    public void clearResult() {
        resultPage.clear();
    }
}
