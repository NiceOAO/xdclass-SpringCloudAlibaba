package net.nice.service;

import dto.VideoDTO;
import domain.Video;
import org.springframework.stereotype.Service;

/**
 * @author 16602
 */

@Service
public interface VideoService {
    Video findById(VideoDTO videoDTO);
}
