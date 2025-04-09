// Arrays para armazenar os dados
const consultorios = [];
const pacientes = [];
const agendamentos = [];

// Função para adicionar um consultório
document.getElementById('formConsultorio').addEventListener('submit', function(e) {
    e.preventDefault();
    const nome = document.getElementById('consultorioNome').value;
    const endereco = document.getElementById('consultorioEndereco').value;

    // Adiciona consultório ao array
    const consultorio = { nome, endereco };
    consultorios.push(consultorio);

    // Limpa o formulário
    document.getElementById('consultorioNome').value = '';
    document.getElementById('consultorioEndereco').value = '';

    // Atualiza a lista de consultórios
    atualizarListaConsultorios();
});

// Função para atualizar a lista de consultórios
function atualizarListaConsultorios() {
    const listaConsultorios = document.getElementById('consultorioList');
    listaConsultorios.innerHTML = ''; // Limpa a lista antes de adicionar os novos consultórios

    consultorios.forEach(function(consultorio, index) {
        const li = document.createElement('li');
        li.textContent = `${consultorio.nome} - ${consultorio.endereco}`;
        listaConsultorios.appendChild(li);
    });
}

// Função para adicionar paciente
document.getElementById('formPaciente').addEventListener('submit', function(e) {
    e.preventDefault();
    const nome = document.getElementById('pacienteNome').value;
    const cpf = document.getElementById('pacienteCpf').value;

    // Adiciona paciente ao array
    const paciente = { nome, cpf };
    pacientes.push(paciente);

    // Limpa o formulário
    document.getElementById('pacienteNome').value = '';
    document.getElementById('pacienteCpf').value = '';

    // Atualiza a lista de pacientes
    atualizarListaPacientes();
});

// Função para atualizar a lista de pacientes
function atualizarListaPacientes() {
    const listaPacientes = document.getElementById('pacienteList');
    listaPacientes.innerHTML = ''; // Limpa a lista antes de adicionar os novos pacientes

    pacientes.forEach(function(paciente, index) {
        const li = document.createElement('li');
        li.textContent = `${paciente.nome} - CPF: ${paciente.cpf}`;
        listaPacientes.appendChild(li);
    });
}

// Função para agendar consulta
document.getElementById('formAgendamento').addEventListener('submit', function(e) {
    e.preventDefault();
    const nomePaciente = document.getElementById('pacienteNome').value;
    const dataConsulta = document.getElementById('dataConsulta').value;
    const horaConsulta = document.getElementById('horaConsulta').value;

    // Adiciona agendamento ao array
    const agendamento = { nomePaciente, dataConsulta, horaConsulta };
    agendamentos.push(agendamento);

    // Limpa o formulário
    document.getElementById('pacienteNome').value = '';
    document.getElementById('dataConsulta').value = '';
    document.getElementById('horaConsulta').value = '';

    // Atualiza a lista de agendamentos
    atualizarListaAgendamentos();
});

// Função para atualizar a lista de agendamentos
function atualizarListaAgendamentos() {
    const listaAgendamentos = document.getElementById('agendamentoList');
    listaAgendamentos.innerHTML = ''; // Limpa a lista antes de adicionar os novos agendamentos

    agendamentos.forEach(function(agendamento, index) {
        const li = document.createElement('li');
        li.textContent = `${agendamento.nomePaciente} - ${agendamento.dataConsulta} - ${agendamento.horaConsulta}`;
        listaAgendamentos.appendChild(li);
    });
}

// Função para gerar relatório financeiro (exemplo simples)
document.getElementById('gerarRelatorio').addEventListener('click', function() {
    const totalConsultas = agendamentos.length;
    const valorConsulta = 150; // Exemplo de valor por consulta
    const totalReceita = totalConsultas * valorConsulta;

    const relatorio = `Total de Consultas: ${totalConsultas}\nReceita Total: R$ ${totalReceita.toFixed(2)}`;
    document.getElementById('relatorioFinanceiro').textContent = relatorio;
});
