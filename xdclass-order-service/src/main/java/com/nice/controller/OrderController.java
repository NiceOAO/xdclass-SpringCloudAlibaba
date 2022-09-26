package com.nice.controller;

import DTO.VideoDTO;
import cn.hutool.core.bean.BeanUtil;
import com.nice.service.VideoService;
import domain.Video;
import domain.VideoOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author:liujiali
 * @Describle:订单服务
 */
@RestController
@RequestMapping("/api/v1/video_order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private VideoService videoService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/save")
    public VideoOrder save(@RequestBody VideoDTO videoDTO) {
        //拿到nacos注册的此服务的所有实例，存在多个可以使用随机数进行简单的负载均衡
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("xdclass-video-service");

        // 初始化一个uri
//        URI uri = null;
        // 拿到的实例信息
//        if (CollUtil.isNotEmpty(serviceInstances)) {
//            ServiceInstance serviceInstance = serviceInstances.get(0);
//            String host = serviceInstance.getHost();
//            Integer port = serviceInstance.getPort();
//            uri = serviceInstance.getUri();
//            logger.info("============ serviceInstances ==============");
//            logger.info("============ host:{} ==============", host);
//            logger.info("============ port:{} ==============", port);
//            logger.info("============ uri:{} ===============", uri);
//        }
        // 远程调用实例接口
//        Video video = restTemplate.postForObject("http://xdclass-video-service/api/v1/video/getVideo", videoDTO, Video.class);

        Video video = videoService.getVideo(videoDTO);
        // 组装结果
        VideoOrder videoOrder = new VideoOrder();
        BeanUtil.copyProperties(video, videoOrder);
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setVideoImg(video.getCoverImg());

        logger.info("============ video serverInfo:{} ===============", video.getServerInfo());
        return videoOrder;
    }

    @RequestMapping("/saveTest")
    public VideoOrder saveTest(@RequestBody VideoDTO videoDTO) {
        try {
            // 五秒延时模拟阻塞
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Video video = videoService.getVideo(videoDTO);
        // 组装结果
        VideoOrder videoOrder = new VideoOrder();
        BeanUtil.copyProperties(video, videoOrder);
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setVideoImg(video.getCoverImg());

        logger.info("============ video serverInfo:{} ===============", video.getServerInfo());
        return videoOrder;
    }
}
