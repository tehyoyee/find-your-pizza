package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Result;
import com.pizzaTest.demo.repository.result.MemoryResultRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryResultRepositoryTest {
    MemoryResultRepository repository = new MemoryResultRepository();

    @AfterEach
    public void afterEach(){
        repository.clearResult();
    }

    @Test
    void save(){
        Result result1 = new Result("따뜻한", "포테토 피자는", "블라블라");
        Result result2 = new Result("차가운", "고구마 피자는", "숼라숼라");

        repository.save(result1);
        repository.save(result2);

        assertThat(result1).isNotSameAs(result2);
    }

    @Test
    void findById(){
        Result resultA = new Result("따뜻한", "포테토 피자는", "블라블라");
        Result resultB = new Result("차가운", "고구마 피자는", "숼라숼라");

        repository.save(resultA);
        repository.save(resultB);

        Result findResult = repository.findById(resultB.getResultId());
        assertThat(findResult).isEqualTo(resultB);
    }
}