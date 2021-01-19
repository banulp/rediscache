package com.banulp.rediscache.controller;

import com.banulp.rediscache.model.BanulpUser;
import com.banulp.rediscache.model.BanulpUserRepository;
import com.banulp.rediscache.service.BanulpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/banulpuser")
public class BanulpUserCacheController {

    @Autowired
    private BanulpUserService banulpUserService;

    @PostMapping("/get/{uid}")
    public BanulpUser add(@PathVariable String uid) {
        return banulpUserService.getByUid(uid);
    }

    @PostMapping("/evict/{uid}")
    public void evict (@PathVariable String uid) {
        banulpUserService.evictByUid(uid);
    }
}
