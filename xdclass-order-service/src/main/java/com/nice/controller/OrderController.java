package com.nice.controller;

import DTO.VideoDTO;
import cn.hutool.core.bean.BeanUtil;
import domain.Video;
import domain.VideoOrder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:liujiali
 * @Describle:订单服务
 */
@RestController
@RequestMapping("/api/v1/video_order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/save")
    public VideoOrder save(@RequestBody VideoDTO videoDTO) {
        Video video = restTemplate.postForObject("http://127.0.0.1:9000/api/v1/video/getVideo", videoDTO, Video.class);
        VideoOrder videoOrder = new VideoOrder();
        BeanUtil.copyProperties(video, videoOrder);
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setVideoImg(video.getCoverImg());
        return videoOrder;
    }
}
