package com.project.security.service;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class ExpiryTokenService {

    @CachePut(cacheNames = "tokenCache", key = "#token")
    public String addTokenToCache(String token) {
        return token;
    }

    @Cacheable(cacheNames = "tokenCache", key = "#token")
    public String getTokenFromCache(String token) {
        return null;
    }
}
