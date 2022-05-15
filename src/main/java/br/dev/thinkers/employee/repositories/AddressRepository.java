package br.dev.thinkers.employee.repositories;

import br.dev.thinkers.employee.domain.Address;
import br.dev.thinkers.employee.domain.Department;

import java.util.List;

public interface AddressRepository {
    void save(Address address);
    void update(Address address);
    void delete(String id);
    Address findById(String id);
    List<Address> findAll();
}
