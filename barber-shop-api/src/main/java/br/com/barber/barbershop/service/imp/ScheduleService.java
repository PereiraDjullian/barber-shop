package br.com.barber.barbershop.service.imp;

import br.com.barber.barbershop.entity.ScheduleEntity;
import br.com.barber.barbershop.repository.IScheduleRepository;
import br.com.barber.barbershop.service.IScheduleService;
import br.com.barber.barbershop.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private  final IScheduleRepository repository;
    private  final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);


    }
}
