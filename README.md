# Sistema de Lista de Jogos

## Descrição do Projeto
Este projeto é apenas o backend de um sistema que gerencia e armazena jogos em um formato de lista dentro de um banco de dados SQL. Ele permite alterar a posição de um jogo específico, como, por exemplo, movê-lo do primeiro lugar para o terceiro.

## Licença
Este projeto está licenciado sob a licença **MIT**. Para mais informações, consulte o arquivo `LICENSE`.

## Tecnologias Utilizadas e Frameworks
- **Java**
- **Spring Boot**
- **Dockerfile**
- **PostegresSQL**

## Como Instalar e Configurar o Projeto

1. **Clone o repositório do projeto** para a sua máquina:

    ```bash
    git clone <URL_DO_REPOSITÓRIO>
    ```

2. **Baixe o framework Spring Boot** em sua máquina.

3. **Execute o projeto** seguindo os passos abaixo, de acordo com o seu sistema operacional:

### Para Windows:
- Abra o terminal e navegue até a pasta onde está o arquivo `mvnw.cmd`.
- Execute o seguinte comando:

    ```bash
    mvnw.cmd spring-boot:run
    ```
- O sistema estará rodando no endereço: `http://localhost:8080`.

### Para Linux/Mac:
- Abra o terminal e navegue até a pasta onde está o arquivo `mvnw`.
- Execute o seguinte comando:

    ```bash
    ./mvn spring-boot:run
    ```
- O sistema estará rodando no endereço: `http://localhost:8080`.

---

## Como Usar o Projeto

Por se tratar apenas de um backend, será necessário utilizar um software de desenvolvimento e teste de APIs, como o **Postman**.  

### Comandos disponíveis:

#### **GET** (para consultar informações do banco de dados):
- Listar todos os jogos:
    ```
    http://localhost:8080/games
    ```
- Consultar um jogo específico pelo ID (ID da tabela `TB_GAME`):
    ```
    http://localhost:8080/games/{id}
    ```
- Listar todas as listas:
    ```
    http://localhost:8080/lists
    ```
- Listar os jogos dentro de uma lista específica:
    ```
    http://localhost:8080/list/{id}/games
    ```

#### **POST** (para alterar a posição de um jogo em uma lista):
- Substituir a posição de um jogo específico:
    ```
    http://localhost:8080/lists/{id}/replacement
    ```

---

## Créditos

### Professor que ensinou a desenvolver o projeto:
[Devsuperior](https://github.com/devsuperior)

### Programador que criou o projeto original:
[Wesley Mazoni](https://github.com/wmazoni)
