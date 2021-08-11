package com.alex.minhasfinancas.api.controller;

import com.alex.minhasfinancas.api.dto.LancamentoDTO;
import com.alex.minhasfinancas.api.dto.UsuarioDTO;
import com.alex.minhasfinancas.exception.ErroAutenticacao;
import com.alex.minhasfinancas.service.LancamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

    private LancamentoService service;

    public LancamentoController(LancamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody LancamentoDTO dto) {
        try {

        } catch (ErroAutenticacao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }   

}
