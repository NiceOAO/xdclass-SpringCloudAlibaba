package net.nice.video.dao;

import com.nice.common.domain.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 16602
 */
@Mapper
@Repository
public interface VideoMapper {
    /**
     * 通过id查询视频信息
     *
     * @return 视频信息
     */
    @Select("select * from video where id = #{videoId}")
    Video selectById(int videoId);
}
