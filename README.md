Projeto de Gerenciamento de pessoas
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
O projeto utiliza:

- Java 11
- Maven 3.6.3
- Spring Boot (última versão)
- Git / GitHub
- Heroku para deploy na nuvem
- IntelliJ

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Padrão arquitetural

- Padrão esolhido: REST;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Informaçõa sobre o REST:

- RESTFUL: significa, o quanto nós estamos aplicando os conceitos de REST;

- Niveis de maturidade REST, segundo Richardson:
  - Level 3 - HyperMedia controls;
  - Level 2 - Http verbs;
  - Level 1 - Resources;
  - Level 0 - The swamp of POX.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Dependências do projeto:

- Para baixar as dependências do projeto: https://start.spring.io/
- Dependências baixadas:
  - Spring Boot DevTools;
  - Lombok;
  - Spring Web;
  - Spring Data JPA;
  - Spring Boot Actuator;
  - H2 Database.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Dicas de configuração da aplicação na IDE:

- Para Criar uma configuração de execução de aplicação:
  - Do lado esquerdo do botão de Run (da parte superior da ide);
  - Clicar na parte de Edit (ou add, se não houver applications);
  - Clicar no botão de mais;
  - Dar um nome para a application;
  - Escolher a classe main;
  - Clicar em ok;
  - Rodar a aplicação, para testar.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Dicas sobre o Heroku:

- Para que o heroku reconheça, e baixe as dependências corretos do projeto:
  - Criar um arquivo na raiz do projeto, com o nome "system.properties";
  - Dentro do arquivo, inserir a seguinte linha: java.runtime.version=11;
  - Obs.: caso sua versão do java seja outra, basta trocar o 11, pela versão correta.

- Para disponibilizar a aplicação no heroku:
  - Após fazer o login, clicar no botão new;
  - Selecionar a opção create new app;
  - Inserir o nome da aplicação (por exemplo: pessoasapi-live);
  - Escolher a região (por exemplo: Estados Unidos);
  - Apertar o botão create app;
  - Selecionar a opção GitHub (na parte de deployment method);
  - Conectar na sua conta do github;
  - Indicar o repositório do projeto no github (por meio de seu nome);
  - Desabilitar o Deploy automática (opcional);
  - Executar o deploy manual (opcional).
    
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Informações sobre as dependêcias do projeto:

- Dependência Lombok:
  - Descrição: por meio de suas notações, faz com que não precisemos escrever os métodos get,set, e nem construtores, as notações mostradas da dependência foram: @Data, @Builder, @AllArgsConstructor, e @NoArgsConstructor (estes, estão na classe Telefone);

- Dependência JPA:
  - Descrição: por meio dela, fazemos a criação do nosso banco de dados (podem usar restrições, relacionamentos, etc), em tempo de execução, as sua anotações são: @Entity, @Id, @GeneratedValue, @Column, @OneToMany (estes, estão na classe Pessoa);

- Dependência H2:
  - Descrição: por meio dela, conseguimos visualizar o nosso banco de dados (no caso, criado em memória): basta ver no console a parte h2, e acessar o link disponível (/h2-console)
  - Obs.: SE OCORRER ALGUM ERRO NA CONEXÃO COM O BANCO, CONSTANDO QUE O MESMO NÃO EXISTE, INSERIR O SEGUINTE CÓDIGO, NO ARQUIVO "application.properties", dentro da pasta resources:
  
    spring.jpa.open-in-view=true
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=


    APÓS INSERIR ESSE CÓDIGO, ACESSE O LINK DO h2-console, e mude a url jdbc para "jdbc:h2:mem:testdb", igual a configuração acima.


