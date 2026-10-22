package br.com.marcossousadev.relacionamentos.controllers;

import br.com.marcossousadev.relacionamentos.business.TagService;
import br.com.marcossousadev.relacionamentos.dtos.tag.CreateTagDto;
import br.com.marcossousadev.relacionamentos.dtos.tag.TagResponseDto;
import br.com.marcossousadev.relacionamentos.exceptions.BadRequestException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
@Validated
public class TagController {
    private final TagService tagService;
    @PostMapping
    public ResponseEntity<String> createTag(@Valid @RequestBody CreateTagDto createTagDto) throws BadRequestException {
        tagService.createTag(createTagDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("tag criada com sucesso");
    }
    @GetMapping
    public List<TagResponseDto> findAllTags() {
        return tagService.listTags();
    }
}
