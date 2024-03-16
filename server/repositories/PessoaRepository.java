package trabalho.server.repositories;

import trabalho.server.models.Pessoa;
import trabalho.server.models.Turma;
import trabalho.server.services.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository implements Repository<Pessoa> {

    private final List<Pessoa> people = new ArrayList<>();

    @Override
    public void create(Pessoa person) {
        people.add(person);
    }

    @Override
    public Pessoa read(String cpf) {
        for (Pessoa person : people) {
            if (person.getCpf().equals(cpf)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void update(Pessoa person) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getCpf().equals(person.getCpf())) {
                people.set(i, person);
                break;
            }
        }
    }

    @Override
    public void delete(String cpf) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getCpf().equals(cpf)) {
                people.remove(i);
                break;
            }
        }
        List<Turma> turmas = ServiceLocator.getRepository(Turma.class).listAll();
        for (Turma turma : turmas) {
            if (turma.hasPessoa(cpf)) {
                turma.removePessoa(cpf);
                ServiceLocator.getRepository(Turma.class).update(turma);
            }
        }
    }

    @Override
    public List<Pessoa> listAll() {
        return new ArrayList<>(people);
    }
}
