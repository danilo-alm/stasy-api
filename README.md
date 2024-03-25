# STASY

STASY é um sistema projetado para ajudar pequenos e médios empreendedores, como donos de mercadinhos ou papelarias de porte médio ou pequeno, a gerenciar seus estoques e vendas. Substituindo os tradicionais "caderninhos", STASY oferece uma interface amigável e fácil de usar, atendendo às necessidades de seus usuários de forma eficiente.

## Introdução

Este projeto foi desenvolvido como parte da disciplina de Engenharia de Software da Universidade Federal de Alagoas, Campus Arapiraca, sob orientação do Professor Alexandre Barbosa. O objetivo é fornecer uma solução simples, porém eficaz, para a gestão de estoque e vendas, utilizando tecnologias modernas e práticas de engenharia de software.

## Tecnologias Utilizadas

- **Front-end:** HTML, CSS, JavaScript com Node.js, Express e Axios (Desenvolvido no Visual Studio Code)
- **Back-end:** Java com Spring Framework (Desenvolvido na IDE IntelliJ) e Lombok
- **Banco de Dados:** MySQL(MariaDB)
- **Controle de Versão:** Git e GitHub
- **Contêinerização:** Docker, Docker Compose
- **Inteligências Artificiais Utilizadas:** Github Copilot, ChatGPT

## Metodologia de Desenvolvimento

O projeto foi desenvolvido utilizando a metodologia XP (Extreme Programming), permitindo uma rápida identificação e adaptação a mudanças. Isso incluiu a produção de protótipos simples para verificação dos requisitos e realização de testes.

### Organização do Código e Padrões de Projeto

- **Classes e Responsabilidades:** O sistema foi estruturado com classes bem definidas, evitando a concentração de responsabilidades em "God Classes". Cada classe foi desenhada para cumprir com um conjunto específico de responsabilidades, proporcionando um código mais limpo e fácil de manter.
- **Padrão MVC:** Utilizamos a arquitetura Modelo-Visão-Controlador (MVC) no back-end, desenvolvido com Java Spring. Essa estrutura organiza o código em três componentes principais: Modelos para a lógica de negócios e acesso a dados, Visões para a interface do usuário, e Controladores para a intermediação da comunicação entre modelos e visões, facilitando a manutenção e a expansão do sistema.

### Reuso de Código

- **GitHub Copilot e Bibliotecas:** Utilizamos o GitHub Copilot para auxiliar na resolução de bugs e na implementação de funcionalidades tanto no front-end quanto no back-end. Além disso, adotamos bibliotecas e frameworks como Node.js, Express, Axios, Spring Framework, e Lombok no back-end para agilizar o desenvolvimento e garantir práticas de código modernas.

### Versionamento e Refatoração

- **Gerenciamento de Versões:** O projeto é mantido no GitHub, com versionamento ativo para acompanhamento das mudanças e evolução do código. Diferentes branches foram utilizadas para organizar o desenvolvimento, incluindo uma branch específica (`refactor-security`) destinada à refatoração do código relacionado à segurança. Contudo, devido a problemas de implementação, essa branch acabou não sendo incorporada ao projeto principal.

## Problemas Conhecidos e Bugs

Atualmente, o sistema STASY está enfrentando alguns problemas conhecidos que impactam a funcionalidade de edição e remoção de produtos. Estamos trabalhando para resolver esses problemas e agradecemos a compreensão e paciência dos usuários.

### Bugs Atuais:
- **Remoção de Produtos:** Produtos que foram vendidos (cadastrados em alguma venda) não podem ser removidos do sistema. Essa restrição foi implementada para manter a integridade dos dados de vendas, mas reconhecemos a necessidade de uma solução que permita a remoção de produtos de forma segura e estamos explorando alternativas para isso.

## Estrutura do Projeto

O projeto está organizado em duas principais pastas:
- `client`: Contém os arquivos do front-end.
- `api`: Contém os arquivos do back-end.

## Como Usar

### Pré-requisitos

- Docker e Docker Compose
- Node.js

#### Instalação do Node.js

Para instalar o Node.js, visite [https://nodejs.org/](https://nodejs.org/) e siga as instruções para o seu sistema operacional.

### Para executar o STASY na sua máquina local, siga os passos abaixo:

1. Clone o repositório:

```bash
https://github.com/danilo-alm/stasy-api.git
```

2. Navegue até a pasta api e construa a JAR do back-end:
```bash
Windows
./mvnw clean package -DskipTests
```
```bash
Linux
./mvnw -Dmaven.test.skip=true install
```
3. Utilize o Docker Compose para construir e iniciar os contêineres do back-end:
```bash
docker-compose up
```
4. Em um novo terminal, navegue até a pasta do cliente, instale as dependências e inicie o front-end:
```bash
npm install
npm start
```

## Desenvolvedores

- Caio Teixeira
- Danilo Augusto
- Noemy Torres
