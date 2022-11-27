package com.github.hoshihon.picshare.service;

import com.github.hoshihon.picshare.VO.ArtVO;
import com.github.hoshihon.picshare.dto.ArtProperties;


public interface ArtService {
    ArtVO queryArt();

    ArtVO addArt(ArtProperties artProperties);

    ArtVO deleteArt(ArtProperties artProperties);

    ArtVO searchArt(int id);


}
