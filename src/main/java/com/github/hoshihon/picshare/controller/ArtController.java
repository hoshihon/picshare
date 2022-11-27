package com.github.hoshihon.picshare.controller;

import com.github.hoshihon.picshare.controller.support.ApiResult;
import com.github.hoshihon.picshare.dto.ArtProperties;
import com.github.hoshihon.picshare.service.ArtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/art")
public class ArtController {

    @Autowired
    private ArtService artService;

    public static final Logger LOG = LoggerFactory.getLogger(ArtController.class);


    @GetMapping("/")
    public ApiResult<ArtProperties> queryArt() {
        return null;
    }

    @PutMapping("/add")
    public ApiResult addArt(ArtProperties artProperties) {
        return null;
    }

    @PostMapping("/update")
    public ApiResult updateArt(ArtProperties artProperties) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ApiResult deleteArt(@PathVariable("id") int id) {
        return null;
    }

    @GetMapping("/search/{id}")
    public ApiResult searchArt(@PathVariable("id") int id) {
        return null;
    }


}
