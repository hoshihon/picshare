package com.github.hoshihon.picshare.dao;

import com.github.hoshihon.picshare.dto.ArtProperties;

import java.util.List;

public interface ArtDAO extends BaseDAO {
    List<ArtProperties> artQuery();

    List<ArtProperties> searchArt(String title);

}
