package trabalho.server.repositories;

import trabalho.server.models.Medico;
import trabalho.server.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MedicoRepository extends PessoaRepository {

    @Override
    public Pessoa read(String cpf) {
        for (Pessoa person : people) {
            if (person.getCpf().equals(cpf) && person instanceof Medico) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Pessoa> listAll() {
        List<Pessoa> pessoas = super.listAll();
        List<Pessoa> medicos = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Medico) {
                medicos.add(pessoa);
            }
        }
        return medicos;
    }
}
