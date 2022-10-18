package net.nice.video.service;

import com.nice.common.dto.VideoDTO;
import com.nice.common.domain.Video;
import org.springframework.stereotype.Service;

/**
 * @author 16602
 */
@Service
public interface VideoService {
    Video findById(VideoDTO videoDTO);
}
