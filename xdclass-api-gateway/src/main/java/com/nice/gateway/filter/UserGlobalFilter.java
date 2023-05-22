package com.nice.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: ljl
 * @date: 2023/5/22 21:41
 * @Description:
 */
@Component
public class UserGlobalFilter implements GlobalFilter, Ordered {
    /**
     * 用户token鉴权过滤器
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //从请求头获取token
        String token = exchange.getRequest().getHeaders().getFirst("token");
        //鉴权规则 JWT鉴权 或者 连接Redis
        if (StringUtils.isBlank(token)) {
            // token为空则返回未授权，并将请求标记为完成
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        // 通过鉴权 则继续下一个过滤器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 过滤器的优先级
        return 0;
    }
}
