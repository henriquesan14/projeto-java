# Projeto Disciplina de Java Avançado
> Sistema Desktop de Clínica Médica para gerenciamento de pacientes, médicos e consultas.
### Tecnologias usadas: 
* Java
* Swing Java
* JCalendar
* iTextPDF
* MySQL



### Para executar o sistema:

1. Adicione ao path do projeto os arquivos:
* Driver JDBC de conexão do MySQL: lib/mysql-connector-java-5.1.47.jar
* Os 4 arquivos .jar do JCalendar: lib/lib/*
2. Importe o arquivo dbclinicajava.sql no seu SGBD.
3. Execute o sistema.
4. Logue com perfil de ADMIN - Login: admin , senha: admin  ou perfil de USER : Login: user, senha: user .

### Funcionalidades do sistema:

* Autenticação de usuários e controle de acesso.
* CRUD de usuários, médicos, pacientes.
* Agendamento de consultas.
* Consultas agendadas do dia atual.

### Regras:
* Só usuário com perfil de ADMIN pode gerenciar outros usuários, e realizar operção de remoção pacientes,médicos e consultas.
* Integridade referencial dos registros, bloqueando remoção de entidade caso ela tenha relacionamentos vinculados.
* Máximo de 10 consultas por dia/turno/médico.
