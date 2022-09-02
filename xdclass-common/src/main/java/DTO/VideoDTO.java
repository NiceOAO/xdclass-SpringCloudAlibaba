package DTO;

import lombok.Data;

/**
 * video查询入参
 */
public class VideoDTO {
    Integer videoId;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}
