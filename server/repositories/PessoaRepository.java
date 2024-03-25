package trabalho.server.repositories;

import trabalho.server.models.Pessoa;
import trabalho.server.models.Hospital;
import trabalho.server.services.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository implements Repository<Pessoa> {

    private final List<Pessoa> people = new ArrayList<>();
    private final List<PessoaRepositoryObserver> observers = new ArrayList<>();

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
                notifyObserversPessoaUpdated(person);
                break;
            }
        }
    }

    @Override
    public void delete(String cpf) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getCpf().equals(cpf)) {
                people.remove(i);
                notifyObserversPessoaDeleted(cpf);
                break;
            }
        }
    }

    @Override
    public List<Pessoa> listAll() {
        return new ArrayList<>(people);
    }

    public void registerObserver(PessoaRepositoryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PessoaRepositoryObserver observer) {
        observers.remove(observer);
    }

    private void notifyObserversPessoaDeleted(String cpf) {
        for (PessoaRepositoryObserver observer : observers) {
            observer.pessoaDeleted(cpf);
        }
    }

    private void notifyObserversPessoaUpdated(Pessoa pessoa) {
        for (PessoaRepositoryObserver observer : observers) {
            observer.pessoaUpdated(pessoa);
        }
    }
}
