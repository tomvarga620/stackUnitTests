import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>(5);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() throws Exception {
        assertEquals(true,stack.isEmpty());

        stack.push(1);
        assertEquals(false,stack.isEmpty());

        stack.empty();

        stack.push(null);
        stack.isEmpty();
    }

    @org.junit.jupiter.api.Test
    void isFull() throws Exception {

        for(int i=0;i<stack.getCapacity();i++){
            stack.push(i);
        }

       assertEquals(true,stack.isFull());

       stack.pop();
       assertEquals(false,stack.isFull());

       stack.empty();
       assertEquals(false,stack.isFull());

       stack.push(null);
       assertEquals(false,stack.isFull());
    }

    @org.junit.jupiter.api.Test
    void push() {
        try {

            assertEquals(true,stack.isEmpty());
            stack.push(null);
            assertEquals(true,stack.isEmpty());

            stack.push(1);
            assertEquals(1,stack.getSize());

            stack.push(2);
            assertEquals(2,stack.getSize());

            stack.empty();

            for(int i=0;i<stack.getCapacity();i++){
                stack.push(i);
            }

            // stack is full
            stack.push(6);
            fail("Unhandled exception when stack is full in void push() test");
        } catch(Exception e) {
            //e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void pop() {

        stack.empty();

        try{
            stack.pop();
            fail("Unhandled exception when stack is empty in void pop() test");
        }catch(Exception e){
            //e.printStackTrace();
        }

        assertEquals(true,stack.isEmpty());

        try {

            stack.push(1);
            stack.push(2);
            stack.pop();
            assertEquals(1,stack.top());
            assertEquals(1,stack.getSize());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void top() {
        try {
            stack.push(1);
            stack.push(2);

            assertEquals(2,stack.top());
            stack.pop();
            assertEquals(1,stack.top());
            assertEquals(1,stack.getSize());

            for(int i=0;i<3;i++){
                stack.push(i);
            }

            assertEquals(stack.top(),stack.topAndPop());

        } catch (Exception e) {
            e.printStackTrace();
        }

            stack.empty();

            try {
                assertEquals(stack.top(), stack.topAndPop());
                fail("Unhandled exception when stack is empty in void top() test");
            }catch (Exception e){
                //e.printStackTrace();
            }

    }

    @org.junit.jupiter.api.Test
    void topAndPop() {

        try {
            stack.push(null);
            assertEquals(null,stack.topAndPop());
            fail("\"Unhandled exception when stack is empty in void topAndPop() test");
        } catch (Exception e) {
            //e.printStackTrace();
        }

        try {
            stack.push(1);
            stack.push(2);
            assertEquals(2,stack.topAndPop());
            assertEquals(1,stack.getSize());
            assertEquals(1,stack.top());
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void getSize() {
        try {
            stack.push(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(0,stack.getSize());
    }

    @org.junit.jupiter.api.Test
    void getCapacity() {

        try {

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        fail("Unhandled exception when stack is full in void getCapacity() test");
        stack.getCapacity();

        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.Test
    void empty() {

        try {

            stack.push(1);
            stack.push(2);
            stack.push(3);

        } catch (Exception e) {
            e.printStackTrace();
        }

        stack.empty();

        assertEquals(true,stack.isEmpty());
        assertEquals(0,stack.getSize());

        try {
            stack.empty();
            assertEquals(0,stack.getSize());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}