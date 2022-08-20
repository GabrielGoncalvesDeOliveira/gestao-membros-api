package com.pontolivre.gestaomembrosapi.church.application;

import com.pontolivre.gestaomembrosapi.church.domain.Church;
import com.pontolivre.gestaomembrosapi.church.service.IChurchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/church")
@Api(tags = {"Church"})
public class ChurchController {

    @Autowired
    private IChurchService iChurchService;

    @PostMapping
    @ApiOperation(value = "Insert an new Church", response = Church.class)
    public ResponseEntity<Church> create(@RequestBody Church church) {
        Church response = iChurchService.create(church);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{churchId}")
    @ApiOperation(value = "Update a Church by uuid", response = Church.class)
    public boolean update(@PathVariable UUID churchId, @RequestBody Church church) {
        return iChurchService.update(churchId, church);
    }

    @PutMapping("/changeStatus/{churchId}")
    @ApiOperation(value = "Change status of church to active or disabled", response = Church.class)
    public boolean changeStatus(@PathVariable UUID churchId) {
        return iChurchService.changeStatus(churchId);
    }

    @GetMapping("/{churchId}")
    @ApiOperation(value = "Retrieve Church by uuid", response = Church.class)
    public ResponseEntity<Church> getOne(@PathVariable  UUID churchId) {
        Church response = iChurchService.getOne(churchId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retrieve all Church", response = Church.class)
    public ResponseEntity<List<Church>> getAll() {
        List<Church> response = iChurchService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
