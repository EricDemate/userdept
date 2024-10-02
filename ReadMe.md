# Spring Boot - Projeto Básico de Gerenciamento de Usuários via API

Este projeto demonstra um sistema básico de gerenciamento de usuários utilizando o Spring Boot, acessível através de uma API. Ele é composto por operações CRUD (Create, Read, Update, Delete) e utiliza o banco de dados H2 em memória.

### Pré-requisitos

Antes de iniciar, certifique-se de ter instalado o Spring Boot, que pode ser baixado e configurado através do 
<a href="https://start.spring.io/" target="_blank">
    <span style="color:#1E90FF"><strong>Spring Initializr</strong></span>
</a>.

### Configurações do Projeto

O projeto foi configurado com as seguintes especificações:
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Project: Maven</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Linguagem: Java</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Spring Boot: 3.3.4</p>

### Metadata do Projeto


<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Group: <span style="background-color: #f0f0f0; color: #555555;">com.dzpinformatica.userdept</span></p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Artifact: <span style="background-color: #f0f0f0; color: #555555;">userdept</span></p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Name: <span style="background-color: #f0f0f0; color: #555555;">userdept</span></p>

### Dependências Utilizadas
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Spring Web</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Spring Data JPA</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> H2 Database</p>

### Configurações Adicionais
No arquivo `pom.xml`, foi adicionado o seguinte plugin para garantir o encoding correto dos recursos:

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-resources-plugin</artifactId>
    <version>3.3.1</version>
    <configuration>
        <encoding>UTF-8</encoding>
    </configuration>
</plugin>
```

### Modelo de Domínio
![Descrição da imagem](https://raw.githubusercontent.com/devsuperior/java-web-spring-2022/main/img/dominio.png)


Como mostra a imagem acima o modelo de domínio é composto pelas seguintes entidades:
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> Department.java</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> User.java</p>

Ambos os arquivos estão no pacote `com.dzpinformatica.userdept.entities` e incluem as devidas anotações para mapeamento JPA.

### Configuração do Banco de Dados
No arquivo `application.properties`, configuramos o banco de dados H2:

```spring.application.name=userdept
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=senha

# Configurações do console web do H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Mostrar o SQL gerado no console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.open-in-view=true
```
Após configurar, o aplicativo pode ser acessado no endereço: <a href="http://localhost:8080/h2-console" target="_blank">http://localhost:8080/h2-console</a>.

### Script de Inicialização do Banco
Como o H2 é um banco de dados em memória, os dados são perdidos após o reinício da aplicação. Para popular o banco automaticamente, foi criado o arquivo `import.sql` na pasta `src/main/resources` com o seguinte conteúdo:

```INSERT INTO tb_department(name) VALUES ('Gestão');
INSERT INTO tb_department(name) VALUES ('Informática');

INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Antonio', 'antonio@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Caio', 'caio@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (1, 'Andrea', 'andrea@gmail.com');
INSERT INTO tb_user(department_id, name, email) VALUES (2, 'Bruna', 'bruna@gmail.com');
```
### Criação dos Endpoints

#### Repositório
Crie uma interface chamada `UserRepository.java` no pacote `com.dzpinformatica.userdept.repositories`, estendendo `JpaRepository` para realizar as operações de banco de dados.

#### Controlador REST
Crie o controlador `UserController.java` no pacote `com.dzpinformatica.userdept.controllers`. Utilize as anotações `@RestController` e `@RequestMapping` para mapear as rotas da API.

#### Métodos Implementados
Os seguintes endpoints foram implementados:
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> <span style="background-color: #f0f0f0; color: #555555; font-weight: bold;">GET /user:</span> Retorna todos os usuários.</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> <span style="background-color: #f0f0f0; color: #555555; font-weight: bold;">GET /user/{id}:</span> Retorna um usuário específico pelo ID.</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> <span style="background-color: #f0f0f0; color: #555555; font-weight: bold;">POST /user:</span> Adiciona um novo usuário.</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> <span style="background-color: #f0f0f0; color: #555555; font-weight: bold;">PUT /user/{id}:</span> Atualiza um usuário existente.</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> <span style="background-color: #f0f0f0; color: #555555; font-weight: bold;">DELETE /user/{id}:</span> Remove um usuário.</p>

### Testes
Use o <a href="https://www.postman.com/" target="_blank"><span style="color:#00008b"><strong>Postman</strong></span></a> ou outra ferramenta de sua escolha para testar as requisições HTTP e verificar se a API está funcionando corretamente.

---
### Sugestões Adicionais

<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> <strong>Documentação:</strong> Adicionar a documentação Swagger pode facilitar a interação com a API.</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> <strong>Validações:</strong> Adicionar validações nos campos de entrada para evitar erros de dados inválidos.</p>
<p><span style="font-size: 20px; color: #1E90FF;">&#8226;</span> <strong>Testes Unitários:</strong> Incluir testes unitários para garantir a robustez do sistema.</p>

---

### Créditos
Este projeto foi inspirado e retirado em grande parte do vídeo do Professor Nelio do canal DevSuperior, disponível em https://www.youtube.com/watch?v=D4frmIHAxEY.
