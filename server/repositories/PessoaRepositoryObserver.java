package trabalho.server.repositories;

import trabalho.server.models.Pessoa;

public interface PessoaRepositoryObserver {
    void pessoaDeleted(String cpf);
    void pessoaUpdated(Pessoa pessoa);
}
