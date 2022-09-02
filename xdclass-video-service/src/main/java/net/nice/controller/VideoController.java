package net.nice.controller;

import DTO.VideoDTO;
import domain.Video;
import net.nice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 16602
 */
@RestController
@RequestMapping("api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/getVideo")
    public Video getVideo(@RequestBody VideoDTO videoDTO){
        return videoService.findById(videoDTO);
    }
}
