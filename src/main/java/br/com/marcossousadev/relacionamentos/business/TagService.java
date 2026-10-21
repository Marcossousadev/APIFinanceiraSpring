package br.com.marcossousadev.relacionamentos.business;

import br.com.marcossousadev.relacionamentos.dtos.tag.CreateTagDto;
import br.com.marcossousadev.relacionamentos.exceptions.BadRequestException;
import br.com.marcossousadev.relacionamentos.infrastructure.models.TagEntity;
import br.com.marcossousadev.relacionamentos.infrastructure.repository.ITagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagService {
    private final ITagRepository tagRepository;
    public void createTag(CreateTagDto createTagDto) throws BadRequestException {
        TagEntity tag = tagRepository.findByName(createTagDto.name())
                .orElse(null);

        if(tag != null) {
           throw new BadRequestException("essa tag já existe!");
        }

        TagEntity newTag = TagEntity.builder().
                name(createTagDto.name())
                .build();
        tagRepository.save(newTag);
    }
}
