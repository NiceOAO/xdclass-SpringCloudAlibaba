package net.nice.video.service.Impl;

import com.nice.common.dto.VideoDTO;
import com.nice.common.domain.Video;
import net.nice.video.dao.VideoMapper;
import net.nice.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author 16602
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video findById(VideoDTO videoDTO) {
        int videoId = videoDTO.getVideoId();
        Video video = videoMapper.selectById(videoId);
        if (ObjectUtils.isEmpty(video)){
            return new Video();
        }
        return video;
    }
}
