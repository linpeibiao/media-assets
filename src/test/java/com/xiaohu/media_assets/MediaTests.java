package com.xiaohu.media_assets;

import com.xiaohu.media_assets.model.domain.Media;
import com.xiaohu.media_assets.service.MediaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiaohu
 * @date 2023/03/05/ 23:00
 * @description
 */
public class MediaTests {
    @Autowired
    private MediaService mediaService;
    @Test
    public void getUrlTest(){
        Media byId = mediaService.getById(1L);
        System.out.println(byId);
        System.out.println();
    }
}
