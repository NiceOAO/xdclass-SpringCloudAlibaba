package com.nice.component.blocked;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 16602
 */
public class OrderUrlBlockedHandler implements BlockExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(OrderUrlBlockedHandler.class);
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e)
            throws Exception {
        // 根据限流异常种类来自定义异常返回数据
        Map<String,Object> exceptionMap = new HashMap<>();
        if(e instanceof FlowException){
            exceptionMap.put("code","-1");
            exceptionMap.put("msg","流量异常！");
            logger.error("流量异常！");
        }else if(e instanceof DegradeException){
            exceptionMap.put("code","-1");
            exceptionMap.put("msg","降级异常！");
            logger.error("降级异常！");
        }else if(e instanceof ParamFlowException){
            exceptionMap.put("code","-1");
            exceptionMap.put("msg","热点参数异常！");
            logger.error("热点参数异常！");
        }else if(e instanceof AuthorityException){
            exceptionMap.put("code","-1");
            exceptionMap.put("msg","应用授权异常！");
            logger.error("应用授权异常！");
        }else if(e instanceof SystemBlockException){
            exceptionMap.put("code","-1");
            exceptionMap.put("msg","系统异常！");
            logger.error("系统异常！");
        }
    }
}
