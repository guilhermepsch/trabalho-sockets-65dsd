package trabalho.server.repositories;

import trabalho.server.models.Paciente;
import trabalho.server.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository extends PessoaRepository {

    @Override
    public Pessoa read(String cpf) {
        for (Pessoa person : people) {
            if (person.getCpf().equals(cpf) && person instanceof Paciente) {
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
            if (pessoa instanceof Paciente) {
                medicos.add(pessoa);
            }
        }
        return medicos;
    }
}
