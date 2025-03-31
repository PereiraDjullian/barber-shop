package br.com.barber.barbershop.service.query;

import br.com.barber.barbershop.entity.ScheduleEntity;

import java.time.OffsetDateTime;
import java.util.List;

public interface IScheduleQueryService {

    ScheduleEntity findById(final Long id);

    List<ScheduleEntity> finalInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);

    void verifyIfScheduleExists(final OffsetDateTime startAt , final OffsetDateTime endAt);

}
