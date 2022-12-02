package com.github.hoshihon.picshare.controller;

import com.github.hoshihon.picshare.controller.support.ApiResult;
import com.github.hoshihon.picshare.dto.ArtProperties;
import com.github.hoshihon.picshare.model.Art;
import com.github.hoshihon.picshare.service.ArtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/art")
public class ArtController {

    @Autowired
    private ArtService artService;

    @Value(("${web.upload-path}"))
    private String uploadPath;


    public static final Logger LOG = LoggerFactory.getLogger(ArtController.class);


    @RequestMapping("/")
    public ApiResult<List<ArtProperties>> queryArt() {
        List<ArtProperties> artProperties = artService.queryArt();
        return ApiResult.success(artProperties);


    }

    @RequestMapping("/add")
    public ApiResult addArt(Art art, MultipartFile file) throws IOException {
        //判断是否存在文件夹
        File imgDir = new File(uploadPath + "/art/");
        if (!imgDir.exists()) {
            imgDir.mkdir();
        }
        //
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            //生成新的文件名称
            String fileNewName = uuid.toString() + suffixName;
            file.transferTo(new File(uploadPath + "/art/" + fileNewName));
            art.setImgLink(uploadPath + "/art/" + fileNewName);
        } else {
            return ApiResult.failed("no such image");
        }
        if (artService.addArt(art)) {
            return ApiResult.success();
        } else {
            return ApiResult.failed("add error");
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
        } else {
            return ApiResult.failed("delete error");
        }

    }

    @GetMapping("/search/{title}")
    public ApiResult<List<ArtProperties>> searchArt(@PathVariable("title") String title) {
        if (artService.searchArt(title).size() != 0) {
            return ApiResult.success(artService.searchArt(title));
        } else {
            return ApiResult.failed("no such Art");
        }

    }


}
