package com.maycon.cursomc.resources;

import com.maycon.cursomc.domain.Cidade;
import com.maycon.cursomc.domain.Estado;
import com.maycon.cursomc.dto.CidadeDTO;
import com.maycon.cursomc.dto.EstadoDTO;
import com.maycon.cursomc.services.CidadeService;
import com.maycon.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/estados")
public class EstadoResource {

    @Autowired
    private EstadoService service;

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<EstadoDTO>> findAll() {
        List<Estado> list = service.findAll();
        List<EstadoDTO> listDto = list.stream().map(EstadoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
    public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
        List<Cidade> list = cidadeService.findByEstado(estadoId);
        List<CidadeDTO> listDto = list.stream().map(CidadeDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
