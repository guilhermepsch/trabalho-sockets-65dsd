package trabalho.server.models;

public class Person {
    private String cpf;
    private String nome;
    private String endereco;

    // Constructors
    public Person() {}

    public Person(String cpf, String nome, String endereco) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setEndereco(endereco);
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        if (!isValidCpf(cpf)) {
            throw new IllegalArgumentException("Invalid CPF format");
        }
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome cannot be null or empty");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereco cannot be null or empty");
        }
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cpf='" + this.getCpf() + '\'' +
                ", nome='" + this.getNome() + '\'' +
                ", endereco='" + this.getEndereco() + '\'' +
                '}';
    }

    private boolean isValidCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
