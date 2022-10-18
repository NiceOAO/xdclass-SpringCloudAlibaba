package com.nice.order.feign;

import com.nice.common.domain.Video;
import com.nice.common.dto.VideoDTO;
import com.nice.order.feign.fallback.VideoServiceFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * feign调用videoService
 * @author 16602
 */
@FeignClient(value = "xdclass-video-service", fallback = VideoServiceFeignFallback.class)
public interface VideoServiceFeign {

    /**
     * 查询视频信息
     * @param videoDTO 查询参数
     * @return Video
     */
    @GetMapping("/api/v1/video/getVideo")
    Video getVideo(VideoDTO videoDTO);

}
