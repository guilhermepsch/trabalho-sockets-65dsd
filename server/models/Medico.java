package trabalho.server.models;

public class Medico extends Pessoa {

    private String especializacao;

    public Medico(String cpf, String nome, String endereco, String historicoMedico){
        super(cpf, nome, endereco);
        this.setEspecializacao(historicoMedico);
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        if (especializacao == null || especializacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Especializacao não pode ser nula ou vazia.");
        }
        this.especializacao = especializacao;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "cpf='" + this.getCpf() + '\'' +
                ", nome='" + this.getNome() + '\'' +
                ", endereco='" + this.getEndereco() + '\'' +
                ", especializacao='" + this.getEspecializacao() + '\'' +
                '}';
    }
}
