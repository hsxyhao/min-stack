package com.hsxyhao.print;


import com.hsxyhao.core.IMinStack;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MinStackPrint {
    public void popPrint(IMinStack stack, Integer value) {
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