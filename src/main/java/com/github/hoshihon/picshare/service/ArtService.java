package com.github.hoshihon.picshare.service;

import com.github.hoshihon.picshare.dto.ArtProperties;
import com.github.hoshihon.picshare.model.Art;

import java.util.List;


public interface ArtService {
    List<ArtProperties> queryArt();

    boolean addArt(Art art);

    boolean deleteArt(long id);

    List<ArtProperties> searchArt(String title);


}
