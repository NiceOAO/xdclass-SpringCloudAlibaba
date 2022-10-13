package net.nice.controller;

import dto.VideoDTO;
import domain.Video;
import net.nice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 16602
 */
@RestController
@RequestMapping("api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/getVideo")
    public Video getVideo(@RequestBody VideoDTO videoDTO, HttpServletRequest request){
        Video video = videoService.findById(videoDTO);
        video.setServerInfo(request.getServerName()+':'+request.getServerPort());
        return video;
    }
}
