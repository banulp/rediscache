package com.banulp.rediscache.controller;

import com.banulp.rediscache.model.BanulpUser;
import com.banulp.rediscache.model.BanulpUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/banulpuser")
public class BanulpUserTempleteController {
    @Autowired
    private BanulpUserRepository banulpUserRepository;

    public BanulpUserTempleteController(BanulpUserRepository BanulpUserRepository) {
        banulpUserRepository = BanulpUserRepository;
    }

    @GetMapping("/all")
    public Iterable<BanulpUser> GetAll() {
        return banulpUserRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public BanulpUser GetAll(@PathVariable("id") final String id) {
        return banulpUserRepository.findById(id).get();
    }

    @PostMapping("/add")
    public BanulpUser add(@RequestBody BanulpUser banulpUser) {
        banulpUserRepository.save(new BanulpUser(banulpUser.getUid(), banulpUser.getUname()));
        return banulpUserRepository.findById(banulpUser.getUid()).get();
    }

}
