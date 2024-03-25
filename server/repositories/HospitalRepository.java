package trabalho.server.repositories;

import trabalho.server.models.Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalRepository implements Repository<Hospital> {
    private final Map<String, Hospital> turmas = new HashMap<>();

    @Override
    public void create(Hospital hospital) {
        turmas.put(hospital.getNome(), hospital);
    }

    @Override
    public Hospital read(String nome) {
        return turmas.get(nome);
    }

    @Override
    public void update(Hospital hospital) {
        turmas.put(hospital.getNome(), hospital);
    }

    @Override
    public void delete(String nome) {
        turmas.remove(nome);
    }

    @Override
    public List<Hospital> listAll() {
        return new ArrayList<>(turmas.values());
    }
}
