
# Relacionamentos API

API REST desenvolvida com **Java e Spring Boot** para praticar o desenvolvimento de back-end, persistência de dados com JPA e mapeamento de relacionamentos entre entidades.

O projeto reúne conceitos como arquitetura em camadas, DTOs para entrada e saída de dados, validação de regras de negócio, tratamento global de exceções e integração com banco de dados MySQL.

## 🎯 Objetivos do projeto

- Praticar o desenvolvimento de APIs REST com Spring Boot.
- Modelar relacionamentos entre entidades com Spring Data JPA.
- Separar responsabilidades entre controllers, services, repositories, entidades e DTOs.
- Implementar validações e respostas de erro consistentes.
- Trabalhar com valores monetários usando `BigDecimal`.
- Aplicar transações para manter a consistência das operações de negócio.

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Jakarta Bean Validation**
- **Maven**
- **Lombok**

## 🧩 Funcionalidades

- Cadastro e consulta de usuários.
- Validação de e-mail já cadastrado.
- Verificação de CPF e CNPJ para evitar duplicidade nos documentos informados.
- Criação e listagem de tags.
- Criação e consulta de transações.
- Associação de transações a carteiras e tags.
- Uso de DTOs para controlar os dados recebidos e retornados pela API.
- Tratamento centralizado de exceções, como recursos não encontrados e requisições inválidas.

## 🏗️ Estrutura do projeto

```text
src/main/java/br/com/marcossousadev/relacionamentos/
├── business/
├── controllers/
├── dtos/
│   ├── responseError/
│   ├── tag/
│   ├── transaction/
│   └── user/
├── enums/
├── exceptions/
├── globalhandler/
└── infrastructure/
    ├── models/
    └── repositories/
```

- **business:** contém os services e as regras de negócio.
- **controllers:** recebe as requisições HTTP e retorna as respostas.
- **dtos:** define os objetos de entrada e saída da API.
- **enums:** contém enumerações, como o tipo de transação.
- **exceptions:** reúne as exceções personalizadas.
- **globalhandler:** centraliza o tratamento de erros.
- **infrastructure:** contém as entidades e os repositories responsáveis pela persistência.

## 🔗 Modelagem e relacionamentos

A aplicação trabalha com entidades de domínio como:

- **User:** representa o usuário cadastrado.
- **Wallet:** representa a carteira associada ao usuário.
- **Transaction:** representa uma transação financeira, com valor, descrição e tipo.
- **Tag:** permite categorizar transações.
- **UsersDocuments:** armazena documentos como CPF e CNPJ.

Os relacionamentos JPA representam as associações entre essas entidades.

A associação entre transações e tags utiliza o conceito de `ManyToMany`, permitindo que uma transação tenha várias tags e que uma tag seja reutilizada em diferentes transações.

## ⚙️ Pré-requisitos

Antes de executar a aplicação, instale:

- JDK 21 ou compatível com a configuração do projeto.
- MySQL.
- Maven ou o Maven Wrapper incluído no repositório.
- IntelliJ IDEA ou outra IDE Java (opcional).

## 🚀 Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/Marcossousadev/APIFinanceiraSpring.git
cd APIFinanceiraSpring
```

### 2. Configure o banco de dados

A aplicação utiliza um banco MySQL chamado `relacionamentos`.

Confira o arquivo `src/main/resources/application.yaml` e configure suas credenciais:

```yaml
spring:
  application:
    name: relacionamentos

  datasource:
    url: jdbc:mysql://localhost:3306/relacionamentos?createDatabaseIfNotExist=true
    username: SEU_USUARIO
    password: SUA_SENHA
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

server:
  servlet:
    context-path: /v1
```

**Importante:** não envie senhas reais ao GitHub. Em ambientes publicados, prefira utilizar variáveis de ambiente para proteger as credenciais.

Com o contexto `/v1` habilitado, os endpoints ficam sob esse prefixo.

### 3. Execute a aplicação

Você pode executar a API de três maneiras:

#### 💻 IntelliJ IDEA (recomendado)

1. Abra o IntelliJ IDEA.
2. Selecione **File → Open** e escolha a pasta do projeto.
3. Aguarde o Maven sincronizar as dependências.
4. Verifique se o JDK 21 está configurado em **File → Project Structure → Project SDK**.
5. Abra a classe `RelacionamentosApplication.java`, localizada no pacote principal da aplicação.
6. Clique no ícone verde de execução ao lado do método `main` ou da declaração da classe.
7. Selecione **Run 'RelacionamentosApplication'**.

Após a inicialização, a API estará disponível em `http://localhost:8080`, por padrão.

#### ⚡ Maven Wrapper (Windows)

Execute no terminal, na raiz do projeto:

```powershell
.\mvnw.cmd spring-boot:run
```

#### ⚙️ Maven instalado

Se você já tiver o Maven instalado, execute:

```bash
mvn spring-boot:run
```
### 4. Verifique a execução

Confira o console do IntelliJ ou do terminal para confirmar que a aplicação iniciou sem erros.

Com o contexto `/v1` habilitado, as rotas da API utilizarão esse prefixo. Por exemplo, um endpoint `/tags` ficará acessível em:

```text
http://localhost:8080/v1/tags
```

A URL final depende dos mappings definidos nos controllers.

## 🌐 Endpoints

Os endpoints abaixo são exemplos ilustrativos. Confirme os caminhos nos controllers da aplicação.

| Recurso | Operações |
|---|---|
| Usuários | Criar e consultar usuários |
| Tags | Criar e listar tags |
| Transações | Criar e consultar transações |

Exemplos de requisições, caso correspondam aos mappings implementados:

```http
POST http://localhost:8080/v1/users
GET  http://localhost:8080/v1/tags
POST http://localhost:8080/v1/transactions
```

Os nomes reais das rotas, os parâmetros obrigatórios e os formatos JSON devem ser conferidos nos controllers e DTOs correspondentes.

## 🧠 Conceitos praticados

- Arquitetura em camadas.
- Injeção de dependências.
- DTOs de criação e resposta.
- Repositories com Spring Data JPA.
- Mapeamentos `@OneToOne`, `@ManyToOne` e `@ManyToMany`, conforme as entidades.
- Validação de dados e regras de negócio.
- Exceções personalizadas e tratamento global de erros.
- Gerenciamento de transações com `@Transactional`.
- Utilização de `BigDecimal` para valores monetários.

## 👨‍💻 Autor

Desenvolvido por **Marcos Sousa**.

- GitHub: [@Marcossousadev](https://github.com/Marcossousadev)

---

Projeto criado para estudo e evolução prática em desenvolvimento back-end com Java e Spring Boot.
