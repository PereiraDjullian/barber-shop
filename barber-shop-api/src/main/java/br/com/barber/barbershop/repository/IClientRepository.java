package br.com.barber.barbershop.repository;
import br.com.barber.barbershop.entity.ClientEntity;
import br.com.barber.barbershop.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IClientRepository extends JpaRepository<ClientEntity,Long>{

    boolean existsByEmail(final String email);

    boolean existsByPhone(final String phone);

    Optional<ClientEntity> findByEmail(final String email);

    Optional<ScheduleEntity> findByPhone(final String phone);
}
