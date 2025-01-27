package tech.buildrun.jbank.controller.dto;

public record PaginationDto(Integer page,
                            Integer pageSize,
                            Long totalElements,
                            Integer totalPages) {
}
