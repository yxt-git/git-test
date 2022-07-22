package com.yxt.demo.order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(A(3));
    }

    public int A(int n){

        if(n==1){
            return 1;
        }
        return n*A(n-1);
    }

}
