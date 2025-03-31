package br.com.barber.barbershop.service.query.impl;

import br.com.barber.barbershop.entity.ClientEntity;
import br.com.barber.barbershop.exception.NotFoundException;
import br.com.barber.barbershop.exception.PhoneInUseException;
import br.com.barber.barbershop.repository.IClientRepository;
import br.com.barber.barbershop.service.query.IClientQueryService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ClientQueryService implements IClientQueryService {

    private final IClientRepository repository;


    @Override
    public ClientEntity findById(final long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Não foi encontrado o cliente de id " + id)
        );
    }

    @Override
    public List<ClientEntity> list() {
        return repository.findAll();
    }

    @Override
    public void verifyPhone(final String phone) {
    if(repository.existsByPhone(phone)){
        var message = "O TELEFONE " + phone + "ja esta em uso";

        throw new PhoneInUseException(message);

    }
    }

    @Override
    public void verifyPhone(final long id, final String phone) {
        var optional = repository.findByPhone(phone);
        if (optional.isPresent() && !Objects.equals(optional.get().getPhone(), phone)) {
            var message = "O telefone " + phone + " já está em uso";
            throw new PhoneInUseException(message);
        }
    }

    @Override
    public void verifyEmail(String email) {
        if (repository.existsByEmail(email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new PhoneInUseException(message);
        }

    }

    @Override
    public void verifyEmail(long id, String email) {

    }
}
