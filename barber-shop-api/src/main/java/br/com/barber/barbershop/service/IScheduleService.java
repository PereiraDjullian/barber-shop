package br.com.barber.barbershop.service;

import br.com.barber.barbershop.entity.ScheduleEntity;

public interface IScheduleService {
    ScheduleEntity save(final ScheduleEntity entity);

    void delete(final long id);
}
