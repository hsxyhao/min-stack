package com.hsxyhao;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
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

    private static void clear(IMinStack stack) {
        while (stack.len() > 0) {
            stack.pop();
        }
    }

}
//  题目：我现在需要实现一个栈，这个栈除了可以进行普通的push、pop操作以外，
//还可以进行getMin的操作，getMin方法被调用后，会返回当前栈的最小值，你会
//怎么做呢？你可以假设栈里面存的都是int整数。

/**
 * 最小值栈
 */
interface IMinStack {

    /**
     * 获取最小值
     *
     * @return min
     */
    int getMin();

    /**
     * 入栈
     *
     * @param value 值
     */
    void push(int value);

    /**
     * 出栈
     *
     * @return 栈顶
     */
    int pop();

    /**
     * 获取栈的长度
     *
     * @return len
     */
    int len();

    /**
     * 获取所有元素
     *
     * @return 栈元素
     */
    List<Integer> getData();

    default void pushPrint(MinStackPrint print, Integer value) {
        if (print == null) {
            return;
        }
        print.pushPrint(this, value);
    }

    default void popPrint(MinStackPrint print, Integer value) {
        if (print == null) {
            return;
        }
        print.popPrint(this, value);
    }

    default int _getMin() {
        if (getData().size() == 0) {
            return -1;
        }
        int min = getData().get(0);
        for (Integer datum : getData()) {
            if (min > datum) {
                min = datum;
            }
        }
        return min;
    }
}

abstract class AbstractMinStack implements IMinStack {

    private MinStackPrint print = new MinStackPrint();
    public abstract void pushValue(int value);

    public abstract int popValue();

    @Override
    public void push(int value) {
        pushValue(value);
        pushPrint(print, value);
    }

    @Override
    public int pop() {
        int value = popValue();
        popPrint(print, value);
        return value;
    }

    @Override
    public int len() {
        return 0;
    }

    @Override
    public List<Integer> getData() {
        return null;
    }
}

@Slf4j
class MinStackPrint {
    public void popPrint(IMinStack stack,Integer value) {
        if (stack == null) {
            log.error("stack is null");
            return;
        }
        log.info("pop({}) \tmin:  {}", value, stack.getMin());
        log.info("        \tdata: {}", _data2Str(stack.getData()));
    }

    public void pushPrint(IMinStack stack,Integer value) {
        if (stack == null) {
            log.error("stack is null");
            return;
        }
        log.info("push({})\tmin:  {}", value, stack.getMin());
        log.info("        \tdata: {}", _data2Str(stack.getData()));
    }

    private String _data2Str(List<Integer> data) {
        StringBuilder sb = new StringBuilder();
        if (data.size() == 0) {
            return "";
        }
        sb.append("|");
        data.forEach((item)->{
            sb.append(item).append("|");
        });
        return sb.toString();
    }
}

/**
 * 可以保存最小值得栈
 */
class MinStack extends AbstractMinStack {

    private int min;
    private int len;
    private List<Integer> data;

    public MinStack() {
        this.data = new ArrayList<>();
        this.len = 0;
        this.min = Integer.MAX_VALUE;
    }

    @Override
    public void pushValue(int value) {
        if (min > value) {
            min = value;
        }
        this.data.add(value);
        this.len++;
    }

    @Override
    public int popValue() {
        if (this.len <= 0) {
            return -1;
        }
        int returnValue = this.data.remove(this.len - 1);
        this.len--;
        if (returnValue == min) {
            this.min = _getMin();
        }
        return returnValue;
    }

    @Override
    public int len() {
        return len;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public List<Integer> getData() {
        return data;
    }

}
