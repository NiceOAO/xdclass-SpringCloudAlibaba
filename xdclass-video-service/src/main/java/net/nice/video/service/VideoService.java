package net.nice.video.service;

import cn.hutool.core.util.NumberUtil;
import com.nice.common.dto.VideoDTO;
import com.nice.common.domain.Video;
import org.springframework.stereotype.Service;

/**
 * @author 16602
 */
@Service
public interface VideoService {
    Video findById(VideoDTO videoDTO);

    public static void main(String[] args) {
        Double a = new Double(100);
        Double b = new Double(3);

        System.out.println(NumberUtil.div(a,b,1));
        System.out.println(NumberUtil.div(a,b,2));
        System.out.println(NumberUtil.div(a,b,3));

    }
}
