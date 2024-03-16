package trabalho.server.repositories;

import trabalho.server.models.Turma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurmaRepository implements Repository<Turma> {
    private final Map<String, Turma> turmas = new HashMap<>();

    @Override
    public void create(Turma turma) {
        turmas.put(turma.getMateria(), turma);
    }

    @Override
    public Turma read(String materia) {
        return turmas.get(materia);
    }

    @Override
    public void update(Turma turma) {
        turmas.put(turma.getMateria(), turma);
    }

    @Override
    public void delete(String materia) {
        turmas.remove(materia);
    }

    @Override
    public List<Turma> listAll() {
        return new ArrayList<>(turmas.values());
    }
}
