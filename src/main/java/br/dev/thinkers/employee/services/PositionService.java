package br.dev.thinkers.employee.services;

import br.dev.thinkers.employee.domain.Position;

import java.util.List;

public interface PositionService {

    void save(Position position);

    void update(Position position);

    void remove(String id);

    Position findPositionById(String id);

    List<Position> loadAllPositions();

    boolean hasEmployee(String id);
}
