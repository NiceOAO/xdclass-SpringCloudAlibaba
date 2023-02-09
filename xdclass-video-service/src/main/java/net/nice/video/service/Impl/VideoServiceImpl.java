package net.nice.video.service.Impl;

import cn.hutool.core.util.ObjectUtil;
import com.nice.common.domain.Video;
import com.nice.common.dto.VideoDTO;
import net.nice.video.dao.VideoMapper;
import net.nice.video.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 16602
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    private VideoMapper videoMapper;

    @Override
    public Video findById(VideoDTO videoDTO) {
        int videoId = videoDTO.getVideoId();
        Video video = videoMapper.selectById(videoId);
        if (ObjectUtil.isEmpty(video)){
            return new Video();
        }
        return video;
    }
}
