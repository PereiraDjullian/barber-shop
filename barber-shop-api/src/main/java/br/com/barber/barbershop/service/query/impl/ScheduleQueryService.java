package br.com.barber.barbershop.service.query.impl;

import br.com.barber.barbershop.entity.ScheduleEntity;
import br.com.barber.barbershop.exception.NotFoundException;
import br.com.barber.barbershop.exception.ScheduleInUseException;
import br.com.barber.barbershop.repository.IScheduleRepository;
import br.com.barber.barbershop.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
@Repository
@AllArgsConstructor
public class ScheduleQueryService implements IScheduleQueryService {
    private final IScheduleRepository repository;


    @Override
    public ScheduleEntity findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agendamento não encontrado")
        );
    }

    @Override
    public List<ScheduleEntity> finalInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyIfScheduleExists(OffsetDateTime startAt, OffsetDateTime endAt) {
        if (repository.existsByStartAtAndEndAt(startAt, endAt)){
            var message = "Já existe um cliente agendado no horário solicitado";
            throw new ScheduleInUseException(message);
        }
    }
}
