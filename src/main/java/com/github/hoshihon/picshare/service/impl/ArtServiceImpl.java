package com.github.hoshihon.picshare.service.impl;

import com.github.hoshihon.picshare.VO.ArtVO;
import com.github.hoshihon.picshare.dao.ArtDAO;
import com.github.hoshihon.picshare.dto.ArtProperties;
import com.github.hoshihon.picshare.service.ArtService;
import org.springframework.stereotype.Service;

@Service
public class ArtServiceImpl implements ArtService {

    private ArtDAO artDAO;

    @Override
    public ArtVO queryArt() {
        return null;
    }

    @Override
    public ArtVO addArt(ArtProperties artProperties) {
        return null;
    }

    @Override
    public ArtVO deleteArt(ArtProperties artProperties) {
        return null;
    }

    @Override
    public ArtVO searchArt(int id) {
        return null;
    }
}
