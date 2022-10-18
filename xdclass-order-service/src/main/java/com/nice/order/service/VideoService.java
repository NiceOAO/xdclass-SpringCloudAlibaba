package com.nice.order.service;

import com.nice.common.dto.VideoDTO;
import com.nice.common.domain.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 16602
 */
@Service
public interface VideoService {

    /**
     * 查询视频信息
     * @param videoDTO 入参
     * @return Video实体
     */
    Video getVideo(VideoDTO videoDTO);

}
