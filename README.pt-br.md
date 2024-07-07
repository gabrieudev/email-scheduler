# API RESTful para agendamento de envio de emails 

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) [![LinkedIn](https://img.shields.io/badge/Connect%20on-LinkedIn-blue)](https://www.linkedin.com/in/gabrieudev) ![GPL License](https://img.shields.io/badge/License-GPL-blue)

Seja bem vindo(a) ao meu projeto de **API RESTful para agendamento de envio de emails**. 

## Tabela de conteúdos

- [Introdução](#introdução)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Configuração](#configuração)
- [Iniciando](#iniciando)
- [Endpoints](#endpoints)
- [Contribuições](#contribuições)
- [Contato](#contato)

## Introdução

O objetivo principal deste projeto é fornecer uma API RESTful capaz de realizar agendamentos de envio de emails. Além disso, também é possível consultar, atualizar ou excluir tais agendamentos.

## Funcionalidades

- Agendamento de envio de emails.
- Atualização, deleçao e consulta com paginação dos agendamentos.
- Integração com o banco de dados MySQL.
- Documentação utilizando Swagger.

## Tecnologias

- ![Java](https://img.shields.io/badge/Java-17-orange): Linguagem de programação.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green): Framework usado para a construção de aplicações.
- ![MySQL](https://img.shields.io/badge/MySQL-Database-blue): Banco de dados relacional.

## Configuração

- Antes de iniciar a aplicação, é necessário alterar algumas variáveis para que o JavaMailSender funcione. Vocêe pode fazer isso navegando até o arquivo: `cd <caminho>/src/main/resources/application.properties`.

## Iniciando

Siga esses passos para executar o projeto na sua máquina:

1. Clone o repositório: `git clone https://github.com/gabrieudev/email-scheduler.git`
2. Navegue para o diretório do projeto: `cd <caminho>`
3. Navegue para o diretório docker: `cd docker`
4. Execute o arquivo docker compose para criar e inicializar o container MySQL: `docker compose up`
5. Volte para o diretório inicial: `cd <caminho>`
6. Construa o projeto: `./mvnw clean install` (para Windows: `mvnw.cmd clean install`)
7. Execute a aplicação: `./mvnw spring-boot:run` (para Windows: `mvnw.cmd spring-boot:run`)

## Endpoints

- `POST /scheduled-emails`: Faz o agendamento de envio dos emails.
- `GET /scheduled-emails/{scheduledEmailId}`: Obtém detalhes de um agendamento por id.
- `GET /scheduled-emails`: Obtém detalhes de todos agendamentos.
- `PUT /scheduled-emails/{scheduledEmailId}`: Atualiza um agendamento.
- `DELETE /scheduled-emails/{scheduledEmailId}`: Deleta um agendamento.

Acesse a documentação completa no endpoint `/swagger-ui.html`

## Contribuições

Contribuições são muito bem vindas! Caso queira contribuir, faça um fork do repositório e crie um pull request.

## Contato

Caso tenha alguma sugestão ou dúvida, entre em contato comigo em [LinkedIn](https://www.linkedin.com/in/gabrieudev)

---

**Licença:** Esse projeto é licenciado sob os termos da [GNU General Public License (GPL)](LICENSE).
