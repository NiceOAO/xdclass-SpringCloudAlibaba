package net.nice.service;

import DTO.VideoDTO;
import domain.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author 16602
 */

@Service
public interface VideoService {
    Video findById(VideoDTO videoDTO);
}
