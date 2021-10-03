package com.alex.minhasfinancas.api.controller;

//<editor-fold defaultstate="collapsed" desc=">>> Imports">
import com.alex.minhasfinancas.api.dto.LancamentoDTO;
import com.alex.minhasfinancas.exception.RegraNegocioException;
import com.alex.minhasfinancas.model.entity.Lancamento;
import com.alex.minhasfinancas.model.entity.Usuario;
import com.alex.minhasfinancas.model.enums.StatusLancamento;
import com.alex.minhasfinancas.model.enums.TipoLancamento;
import com.alex.minhasfinancas.service.LancamentoService;
import com.alex.minhasfinancas.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//</editor-fold>

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {
    
    private LancamentoService service;
    private UsuarioService usuarioService;
    
    public LancamentoController(LancamentoService service) {
        this.service = service;
    }
    
//    @PostMapping
//    public ResponseEntity salvar(@RequestBody LancamentoDTO dto) {
//        
//    }
    
    private Lancamento converter(LancamentoDTO dto) {
        Lancamento lancamento = new Lancamento();
        lancamento.setId(dto.getId());
        lancamento.setDescricao(dto.getDescricao());
        lancamento.setAno(dto.getAno());
        lancamento.setMes(dto.getMes());
        lancamento.setValor(dto.getValor());
        
        Usuario usuario = usuarioService.obterPorId(dto.getUsuario())
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado para o Id informado"));
        
        lancamento.setUsuario(usuario);
        lancamento.setTipo(TipoLancamento.valueOf(dto.getTipo()));
        lancamento.setStatus(StatusLancamento.valueOf(dto.getStatus()));
        
        return lancamento;
    }
    
}
