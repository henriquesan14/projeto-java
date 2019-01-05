# Projeto Disciplina de Java Avançado
> Sistema de Clínica Médica para gerenciamento de pacientes, médicos e consultas.
### Tecnologias usadas: 
* Java
* JCalendar
* iTextPDF
* Mysql



### Para executar o sistema:

1. Baixe todas depedência do arquivo pom.xml
2. Configure o arquivo **application.properties** com as configurações do seu banco de dados.
3. Logue com perfil de ADMIN - Login: admin , senha: admin  ou perfil de Medico : Login: henrique, senha: 123456 .

### Funcionalidades do sistema:

* CRUD de especialidades, médicos, pacientes, medicamentos.
* Agendamento de consultas.
* Consultas agendadas e em andamento do dia vigente.
* Opção de Atender consulta, Agendar retorno, Finalizar consulta, Gerenciar receitas.
* Impressão de receitas.
* Tela inicial com quantidade de consultas do dia, do mês atual, etc.

### Regras:
* Perfil de médico só gerencia medicamentos, consultas e receitas.
* Médico não pode ter mais de uma consulta em andamento.
* Máximo de 10 consultas por dia/turno/médico.
