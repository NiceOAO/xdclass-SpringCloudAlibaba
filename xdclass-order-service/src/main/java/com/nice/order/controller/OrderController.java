package com.nice.order.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.nice.order.service.VideoService;
import com.nice.common.domain.Video;
import com.nice.common.domain.VideoOrder;
import com.nice.common.dto.VideoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author:liujiali
 * @Describle:订单服务
 */
@RestController
@RequestMapping("/api/v1/video_order")
public class OrderController {

    @Resource
    private VideoService videoService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    
    @RequestMapping("/save")
    public VideoOrder save(@RequestBody VideoDTO videoDTO, HttpServletRequest httpServletRequest) {

        Video video = videoService.getVideo(videoDTO);
        // 组装结果
        logger.info("============ order url:{} ===============", httpServletRequest.getServerPort());
        logger.info("============ video serverInfo:{} ===============", video.getServerInfo());
        VideoOrder result = getVideoOrderByVideo(video);
        result.setOrderPort(StrUtil.toString(httpServletRequest.getServerPort()));
        return result;
    }

    @RequestMapping("/saveTest")
    public VideoOrder saveTest(@RequestBody VideoDTO videoDTO) {
        try {
            // 五秒延时模拟阻塞
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 抛出一个异常 模拟熔断

        int errorFlag = new Random().nextInt();
        logger.info("============ error flag : {}============",errorFlag);
        if(errorFlag % 3 == 0){
            throw new RuntimeException();
        }

        Video video = videoService.getVideo(videoDTO);
        // 组装结果
        logger.info("============ video serverInfo:{} ===============", video.getServerInfo());
        return getVideoOrderByVideo(video);
    }

    /**
     * 根据 video 属性生成 videoOrder
     * @param video Video
     * @return VideoOrder
     */
    private VideoOrder getVideoOrderByVideo(Video video){
        VideoOrder videoOrder = new VideoOrder();
        BeanUtil.copyProperties(video, videoOrder);
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setVideoImg(video.getCoverImg());
        return videoOrder;
    }
}
