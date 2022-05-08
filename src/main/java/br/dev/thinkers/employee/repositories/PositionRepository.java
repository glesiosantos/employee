package br.dev.thinkers.employee.repositories;

import br.dev.thinkers.employee.domain.Position;

import java.util.List;

public interface PositionRepository {

    void save(Position position);
    void update(Position position);
    void delete(String id);
    Position findById(String id);
    List<Position> findAll();
}
