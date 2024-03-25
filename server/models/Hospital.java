package trabalho.server.models;

import trabalho.server.repositories.PessoaRepository;
import trabalho.server.repositories.PessoaRepositoryObserver;
import trabalho.server.services.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class Hospital implements PessoaRepositoryObserver {
    private String nome;
    private String endereco;
    private List<Pessoa> pessoas;

    public Hospital(String nome, String endereco) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.pessoas = new ArrayList<>();
        PessoaRepository pessoaRepository = (PessoaRepository) ServiceLocator.getRepository(Pessoa.class);
        pessoaRepository.registerObserver(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Matéria não pode ser nula ou vazia.");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return nome;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Matéria não pode ser nula ou vazia.");
        }
        this.endereco = endereco;
    }

    public List<Pessoa> getPessoas() {
        return new ArrayList<>(pessoas);
    }

    public void addPessoa(Pessoa pessoa) {
        if (pessoa == null) {
            throw new IllegalArgumentException("Pessoa não pode ser nula.");
        }
        pessoas.add(pessoa);
    }

    public void clearPessoas() {
        this.pessoas.clear();
    }

    public boolean hasPessoa(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hospital{ nome='").append(nome).append("', endereco='").append(endereco).append("', pessoas=[");
        for (Pessoa pessoa : pessoas) {
            sb.append(pessoa).append(", ");
        }
        if (!pessoas.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length()); // Remove last comma and space
        }
        sb.append("]}");
        return sb.toString();
    }

    @Override
    public void pessoaDeleted(String cpf) {
        Pessoa pessoaToRemove = null;
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                pessoaToRemove = pessoa;
                break;
            }
        }
        if (pessoaToRemove != null) {
            pessoas.remove(pessoaToRemove);
        }
    }

    @Override
    public void pessoaUpdated(Pessoa newPessoa) {
        Pessoa pessoaToUpdate = null;
        for (Pessoa pessoa : pessoas){
            if (pessoa.getCpf().equals(newPessoa.getCpf())) {
                pessoaToUpdate = pessoa;
                break;
            }
        }
        if (pessoaToUpdate != null) {
            pessoas.remove(pessoaToUpdate);
            pessoas.add(newPessoa);
        }
    }
}
