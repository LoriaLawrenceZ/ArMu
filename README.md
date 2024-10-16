<div align="center" name="readme-top">
    <h1>ArMu</h1>
</div>

![thumbnail-Desafio Java](https://github.com/jacqueline-oliveira/3355-java-desafio/assets/66698429/4b068d55-5cfc-480c-b94f-7d48b3c91eb3)

# Desafio


Vamos implementar uma aplicação para armazenar dados de nossos artistas e músicas preferidos em um banco de dados relacional, podendo buscar informações por artistas e consultar dados sobre os mesmos através de integração com a API do ChatGPT.

- Você precisará de uma classe Artista, com os dados para representar o mesmo;
- Será necessário também uma classe específica para representar as músicas;
- Para o artista, pode praticar a implementação de *enum*, para definir o tipo do artista, por exemplo: solo, dupla ou banda;
- Lembre-se de criar o projeto através do site do [Spring Initializr](https://start.spring.io/), onde já é possível adicionar as dependências do Spring Data JPA e do PostgreSQL;
- Crie uma classe principal com o menu, com as opções desejadas, como: cadastrar artista, cadastrar música, pesquisar músicar por artistas, etc;
- Lembre-se de estender o CommandLineRunner na classe do Spring, sobrescrevendo o método *run* para chamar o menu criado.



## 🔨 Objetivos do projeto

- O objetivo do projeto é praticar a modelagem de classes e relacionamentos utilizando o Spring Data JPA;
- É importante descrever e implementar corretamente a relação entre Artista e Música, visto que um artista pode estar associado a mais de uma música;
- Uma música só deve ser salva no banco de dados, caso o Artista tenha sido previamente cadastrado;
- Praticaremos *derived queries* e *JPQL* para verificar se o artista já está cadastrado e buscar músicas por um determinado artista;
- Faremos a integração com a API do ChatGPT para buscar informações sobre um determinado artista.



Bom desafio!

---

---

---

1. Spring initializer 
  - PostgreSQL Driver
  - Spring Data JPA
2. application.properties
   - Setando a url do banco de dados
      - `spring.datasource.url=jdbc:postgresql://localhost:5432/armu`
   - Setando o usuário do banco de dados
      - `spring.datasource.username=postgres`
   - Setando a senha do banco de dados
      - `spring.datasource.password=postgres`
   - Trecho que explicita que permite o hibernate crie as tabelas automaticamente
      - `spring.jpa.hibernate.ddl-auto=update`
   - Trecho que permite que o hibernate mostre o sql gerado
      - `spring.jpa.show-sql=true`
   - Trecho que permite que o hibernate formate o sql gerado
      - `spring.jpa.properties.hibernate.format_sql=true`
   - Trecho que explicita o dialeto do banco de dados
      - `hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect`
3.