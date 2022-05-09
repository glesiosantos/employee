package br.dev.thinkers.employee.services.impl;

import br.dev.thinkers.employee.domain.Position;
import br.dev.thinkers.employee.repositories.PositionRepository;
import br.dev.thinkers.employee.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void update(Position position) {
        positionRepository.update(position);
    }

    @Override
    public void remove(String id) {
        positionRepository.delete(id);
    }

    @Override
    public Position findPositionById(String id) {
        return positionRepository.findById(id);
    }

    @Override
    public List<Position> loadAllPositions() {
        return positionRepository.findAll();
    }
}
