package com.example.turtle.project_achoo.Function.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LikeProductDTO_info {

    @SerializedName("LikeProductDTO")
    @Expose
    private List<LikeProductDTO> likeProductDTO = null;

    public List<LikeProductDTO> getLikeProductDTO() {
        return likeProductDTO ;
    }

}
