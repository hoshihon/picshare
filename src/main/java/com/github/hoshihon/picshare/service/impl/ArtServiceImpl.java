package com.github.hoshihon.picshare.service.impl;

import com.github.hoshihon.picshare.VO.ArtVO;
import com.github.hoshihon.picshare.dao.ArtDAO;
import com.github.hoshihon.picshare.dto.ArtProperties;
import com.github.hoshihon.picshare.model.Art;
import com.github.hoshihon.picshare.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArtServiceImpl implements ArtService {
    @Autowired
    private ArtDAO artDAO;

    @Override
    public List<ArtProperties> queryArt() {
        List<ArtProperties> artProperties = artDAO.artQuery();
        return artProperties;
    }

    @Override
    public boolean addArt(Art art) {
        art.setUploadTime(new Date());
        //登陆取得状态后更改
        art.setUserId(1);
        artDAO.insert(art);

        return true;
    }

    @Override
    public boolean deleteArt(long id) {

        artDAO.delete(id);
        return true;


    }

    @Override
    public ArtVO searchArt(int id) {
        return null;
    }
}
