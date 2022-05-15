package br.dev.thinkers.employee.repositories.impl;

import br.dev.thinkers.employee.domain.Address;
import br.dev.thinkers.employee.repositories.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryImpl extends AbstractRepository<Address, String> {
}
