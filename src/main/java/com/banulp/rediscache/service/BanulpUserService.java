package com.banulp.rediscache.service;

import com.banulp.rediscache.model.BanulpUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BanulpUserService {

    @Cacheable(cacheNames = "BNPTTCACHE", key = "#uid")
    public BanulpUser getByUid(String uid) {
        log.info(uid + "was not cached. but now cache");
        return new BanulpUser(uid, uid+"name");
    }

    @CacheEvict(cacheNames = "BNPTTCACHE", key = "#uid")
    public void evictByUid(String uid) {
        log.info(uid+" is evicted.");
    }

    @CacheEvict(cacheNames = "BNPTTCACHE", allEntries = true)
    public void evictdb() {
    }
}
