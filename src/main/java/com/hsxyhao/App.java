package com.hsxyhao;

import com.hsxyhao.core.IMinStack;
import com.hsxyhao.core.LinkedMinStack;
import com.hsxyhao.core.MinStack;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 *
 *   题目：我现在需要实现一个栈，这个栈除了可以进行普通的push、pop操作以外，
 * 还可以进行getMin的操作，getMin方法被调用后，会返回当前栈的最小值，你会
 * 怎么做呢？你可以假设栈里面存的都是int整数。
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        IMinStack minStack = new LinkedMinStack();
        randomData(minStack);
        log.info("=====================================================");
        clear(minStack);
    }

    private static void randomData(IMinStack stack) {
        Random random = new Random();
        int size = random.nextInt(5) + 5;
        for (int i = 0; i < size; i++) {
            stack.push(random.nextInt(size));
        }
    }

    private static void clear(IMinStack stack) throws Exception {
        while (stack.len() > 0) {
            stack.pop();
        }
    }
}
