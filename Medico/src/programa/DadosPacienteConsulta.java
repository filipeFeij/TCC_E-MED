package programa;

    // classe para cria��o de todos os m�todos necess�rios para a web service
    // view do usu�rio

public class DadosPacienteConsulta extends agendaconsultas {
	
	// mostrar data
	// hor�rio
	// m�dico
	// local
	// motivo (descri��o)
    
	// vari�veis necess�rias para o mobile visualizar seus m�todos
	
	public String paciente;
	public String data;
	public String horario;
	public String medico;
	public String local;
	public String motivo;

	// m�todos getters and setters
	
	public String getPaciente() {
		return paciente;
	}
	
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	// criar um web service instanciando objetos e chamando os m�todos referentes a esta classe
	
	
}
