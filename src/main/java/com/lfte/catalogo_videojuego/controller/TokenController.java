package com.lfte.catalogo_videojuego.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenController {
    @GetMapping("/anular/{tokenId:.*}")
    public void revocarToken(@PathVariable("tokenId") String token) {
        //tokenServices.revokeToken(token);

    }
}
