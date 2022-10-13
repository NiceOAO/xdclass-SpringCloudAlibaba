package com.nice.service;

import dto.VideoDTO;
import domain.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 16602
 */
@Service
@FeignClient("xdclass-video-service")
public interface VideoService {

    @GetMapping("/api/v1/video/getVideo")
    Video getVideo(VideoDTO videoDTO);
}
