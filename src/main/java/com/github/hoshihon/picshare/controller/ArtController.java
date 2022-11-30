package com.github.hoshihon.picshare.controller;

import com.github.hoshihon.picshare.controller.support.ApiResult;
import com.github.hoshihon.picshare.dto.ArtProperties;
import com.github.hoshihon.picshare.model.Art;
import com.github.hoshihon.picshare.service.ArtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/art")
public class ArtController {

    @Autowired
    private ArtService artService;

    public static final Logger LOG = LoggerFactory.getLogger(ArtController.class);


    @RequestMapping("/")
    public ApiResult<List<ArtProperties>> queryArt() {
        List<ArtProperties> artProperties = artService.queryArt();
        return ApiResult.success(artProperties);


    }

    @RequestMapping("/add")
    public ApiResult addArt(Art art) {

        if (artService.addArt(art)) {
            return ApiResult.success();
        } else {
            return ApiResult.failed("register error");
        }
    }

    @PostMapping("/update")
    public ApiResult updateArt(ArtProperties artProperties) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ApiResult deleteArt(@PathVariable("id") long id) {
        if (artService.deleteArt(id)) {
            return ApiResult.success("delete complete");
        }else {
            return ApiResult.failed("delete error");
        }

    }

    @GetMapping("/search/{id}")
    public ApiResult searchArt(@PathVariable("id") long id) {
        return null;
    }


}
