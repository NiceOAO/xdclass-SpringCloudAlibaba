package com.nice.order.feign.fallback;

import com.nice.common.domain.Video;
import com.nice.common.dto.VideoDTO;
import com.nice.order.feign.VideoServiceFeign;
import org.springframework.stereotype.Service;

/**
 * @author 16602
 */
@Service
public class VideoServiceFeignFallback implements VideoServiceFeign {
    @Override
    public Video getVideo(VideoDTO videoDTO) {
        Video video = new Video();
        video.setTitle("失败的video");
        return video;
    }
}
