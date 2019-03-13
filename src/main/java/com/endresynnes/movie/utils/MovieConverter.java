package com.endresynnes.movie.utils;

import com.endresynnes.movie.models.MovieDto;
import com.endresynnes.movie.models.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class MovieConverter {

    public static MovieDto entityToDto(MovieEntity movieEntity){
        var dto = new MovieDto();
        dto.setId(movieEntity.getId().toString());
        dto.setTitle(movieEntity.getTitle());
        dto.setAgeLimit(movieEntity.getAgeLimit());
        return dto;
    }

    public static List<MovieDto> entityToDto(Iterable<MovieEntity> entities){
        var movies = new ArrayList<MovieDto>();

        for (MovieEntity entity : entities) {
            movies.add(entityToDto(entity));
        }

        return movies;
    }

    public static MovieEntity dtoToEntity(MovieDto dto){
        var entity = new MovieEntity();
        entity.setTitle(dto.getTitle());
        entity.setAgeLimit(dto.getAgeLimit());
        return entity;
    }
}
