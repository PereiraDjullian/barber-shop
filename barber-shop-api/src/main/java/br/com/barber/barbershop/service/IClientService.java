package br.com.barber.barbershop.service;

import br.com.barber.barbershop.entity.ClientEntity;

public interface IClientService {
    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final long id);



}
