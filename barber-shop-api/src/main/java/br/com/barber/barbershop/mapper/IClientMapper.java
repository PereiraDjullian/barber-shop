package br.com.barber.barbershop.mapper;

import br.com.barber.barbershop.controller.request.SaveClientRequest;
import br.com.barber.barbershop.controller.request.UpdateClientRequest;
import br.com.barber.barbershop.controller.response.ClientDetailResponse;
import br.com.barber.barbershop.controller.response.ListClientResponse;
import br.com.barber.barbershop.controller.response.SaveClientResponse;
import br.com.barber.barbershop.controller.response.UpdateClientResponse;
import br.com.barber.barbershop.entity.ClientEntity;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.springframework.http.HttpStatus.CREATED;

@Mapper(componentModel = SPRING)
public interface IClientMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "schedules",ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);



}
