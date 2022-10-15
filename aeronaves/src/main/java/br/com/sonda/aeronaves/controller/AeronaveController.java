package br.com.sonda.aeronaves.controller;

import br.com.sonda.aeronaves.dto.AeronaveDto;
import br.com.sonda.aeronaves.dto.form.AeronaveForm;
import br.com.sonda.aeronaves.model.Aeronave;
import br.com.sonda.aeronaves.repository.AeronaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/aeronaves")
public class AeronaveController {

    @Autowired
    private AeronaveRepository aeronaveRepository;

    @RequestMapping("/get")
    public List<AeronaveDto> aeronavesList() {
        List<Aeronave> aeronave = aeronaveRepository.findAll();
        return AeronaveDto.converter(aeronave);
    }

    @PostMapping
    public ResponseEntity<AeronaveDto> cadastrarAeronave(@RequestBody AeronaveForm aeronaveForm, UriComponentsBuilder uriBilder){
        Aeronave aeronave = aeronaveForm.converter(aeronaveRepository);
        aeronaveRepository.save(aeronave);

        URI uri = uriBilder.path("/aeronaves/{id}").buildAndExpand(aeronave.getId()).toUri();
        return ResponseEntity.created(uri).body(new AeronaveDto(aeronave));
    }
}
