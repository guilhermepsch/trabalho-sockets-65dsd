package trabalho.server.models;

public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;

    public Pessoa(String cpf, String nome, String endereco) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setEndereco(endereco);
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        if (!isValidCpf(cpf)) {
            throw new IllegalArgumentException("Formato de CPF invalido");
        }
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereco não pode ser nulo ou vazio");
        }
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf='" + this.getCpf() + '\'' +
                ", nome='" + this.getNome() + '\'' +
                ", endereco='" + this.getEndereco() + '\'' +
                '}';
    }

    private boolean isValidCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
