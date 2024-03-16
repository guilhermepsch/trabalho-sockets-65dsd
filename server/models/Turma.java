package trabalho.server.models;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String materia;
    private List<Pessoa> pessoas;

    public Turma(String materia) {
        this.setMateria(materia);
        this.pessoas = new ArrayList<>();
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        if (materia == null || materia.trim().isEmpty()) {
            throw new IllegalArgumentException("Matéria não pode ser nula ou vazia.");
        }
        this.materia = materia;
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

    public void removePessoa(String cpf) {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma{ materia='").append(materia).append("', pessoas=[");
        for (Pessoa pessoa : pessoas) {
            sb.append(pessoa).append(", ");
        }
        if (!pessoas.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length()); // Remove last comma and space
        }
        sb.append("]}");
        return sb.toString();
    }
}
