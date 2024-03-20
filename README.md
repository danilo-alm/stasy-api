# STASY

STASY é um sistema projetado para ajudar pequenos e médios empreendedores, como donos de mercadinhos ou papelarias de porte médio ou pequeno, a gerenciar seus estoques e vendas. Substituindo os tradicionais "caderninhos", STASY oferece uma interface amigável e fácil de usar, atendendo às necessidades de seus usuários de forma eficiente.

## Introdução

Este projeto foi desenvolvido como parte da disciplina de Engenharia de Software da Universidade Federal de Alagoas, Campus Arapiraca, sob orientação do Professor Alexandre Barbosa. O objetivo é fornecer uma solução simples, porém eficaz, para a gestão de estoque e vendas, utilizando tecnologias modernas e práticas de engenharia de software.

## Tecnologias Utilizadas

- **Front-end:** HTML, CSS, JavaScript com Node.js, Express e Axios (Desenvolvido no Visual Studio Code)
- **Back-end:** Java com Spring Framework (Desenvolvido na IDE IntelliJ)
- **Banco de Dados:** MySQL(MariaDB)
- **Controle de Versão:** Git e GitHub
- **Contêinerização:** Docker, Docker Compose
- **Inteligências Artificiais Utilizadas:** Github Copilot Copilot, ChatGPT

## Metodologia de Desenvolvimento

O projeto foi desenvolvido utilizando a metodologia XP (Extreme Programming), permitindo uma rápida identificação e adaptação a mudanças. Isso incluiu a produção de protótipos simples para verificação dos requisitos e realização de testes.

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
... colocar quando tiver no github
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

### Realizando Vendas

#### Para realizar vendas, é necessário obter o hash do vendedor, que é gerado a cada nova instância do Docker. Para isso, siga os passos abaixo:

1. Acesse http://localhost:8080/users para visualizar a lista de usuários.
2. Copie o hash do usuário desejado.
3. Cole o hash copiado no campo sellerId dentro do arquivo public/sales.html, substituindo o valor existente.

O front-end será servido em http://localhost:3000. Para acessar a aplicação, abra seu navegador e digite localhost:3000.

## Desenvolvedores

- Caio Teixeira
- Danilo Augusto
- Noemy Torres
