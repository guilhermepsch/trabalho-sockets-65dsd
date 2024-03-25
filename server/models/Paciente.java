package trabalho.server.models;

public class Paciente extends Pessoa {

    private String historicoMedico;

    public Paciente(String cpf, String nome, String endereco, String historicoMedico){
        super(cpf, nome, endereco);
        this.setHistoricoMedico(historicoMedico);
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        if (historicoMedico == null || historicoMedico.trim().isEmpty()) {
            throw new IllegalArgumentException("Historico medico não pode ser nulo ou vazio.");
        }
        this.historicoMedico = historicoMedico;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "cpf='" + this.getCpf() + '\'' +
                ", nome='" + this.getNome() + '\'' +
                ", endereco='" + this.getEndereco() + '\'' +
                ", historicoMedico='" + this.getHistoricoMedico() + '\'' +
                '}';
    }
}
