package com.nice.order.service.impl;

import com.nice.common.domain.Video;
import com.nice.common.dto.VideoDTO;
import com.nice.order.feign.VideoServiceFeign;
import com.nice.order.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 16602
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoServiceFeign videoServiceFeign;

    @Override
    public Video getVideo(VideoDTO videoDTO) {
        return videoServiceFeign.getVideo(videoDTO);
    }
}
