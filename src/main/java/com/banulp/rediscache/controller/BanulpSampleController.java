package com.banulp.rediscache.controller;

import com.banulp.rediscache.model.BanulpUser;
import com.banulp.rediscache.service.BanulpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BanulpSampleController {

    @Autowired
    private BanulpUserService banulpUserService;

    @GetMapping("/gamedata.h3/friend_info")
    public String add() {
//        return "{\"friend_member\":\"\"}\n";
//        return "{\"friend_member\":[{\"fav_team_id\":\"18\",\"team_lv\":\"39\",\"team_name\":\"옥희호랑이\"}]} ";
        return "{\"friend_member\":[]} ";
    }

}
