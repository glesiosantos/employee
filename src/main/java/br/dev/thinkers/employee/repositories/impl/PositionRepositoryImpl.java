package br.dev.thinkers.employee.repositories.impl;

import br.dev.thinkers.employee.domain.Position;
import br.dev.thinkers.employee.repositories.AbstractRepository;
import br.dev.thinkers.employee.repositories.PositionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PositionRepositoryImpl extends AbstractRepository<Position, String> implements PositionRepository {
}
