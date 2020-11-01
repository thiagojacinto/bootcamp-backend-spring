# [Bootcamp](https://github.com/thiagojacinto/pos-unit-porto/tree/master/Bootcamp2): Projeto e-commerce 
 Bootcamp Backend, projeto de um e-commerce utilizando Spring Boot.

 ## Usando

 O primeiro passo é configurar a conexão com um banco PostegreSQL, configurando o _application.properties_ como [este exemplo](https://docs.microsoft.com/pt-br/azure/developer/java/spring-framework/configure-spring-data-jpa-with-azure-mysql#configure-spring-boot-to-use-azure-database-for-mysql).

 A partir disso, é possível rodar o projeto pelo Maven (como instalar? [Aqui](https://maven.apache.org/install.html)), a partir do comando `mvnw spring-boot:run` realizando no diretório.

 Outra opção é realizar o build com o comando `mvnw clean package` e então executando o arquivo JAR resultante, especificando a versão do projeto obtida no pom.xml, e a URL de conexão com um SGBD **PostgreSQL**.

 ```
 java -jar target/ecommerce-{VERSAO}.jar --spring.datasource.url=${JDBC_DATABASE_URL}
 ```

 ## Testando

 Uma vez rodando o serviço, é possível realizar chamadas HTTP, como o exemplo abaixo:

```
 curl -X GET "http://localhost:8080/v1/produtos/marca/1?itens=5&pagina=0" -H "accept: */*" | json_pp
```
com o qual se espera receber como resposta um JSON conforme exemplo seguinte:
```
 {
   "sort" : {
      "sorted" : false,
      "empty" : true,
      "unsorted" : true
   },
   "last" : true,
   "pageable" : { ... },
   "first" : true,
   "totalPages" : 1,
   "number" : 0,
   "numberOfElements" : 1,
   "size" : 5,
   "content" : [
      {
         "precoUnitario" : 529.99,
         "descricao" : "Um produto para gerenciar pacotes",
         "nome" : "Maven",
         "categoria" : {
            "id" : 3,
            "ativo" : true,
            "nome" : "Livraria"
         },
         "marca" : {
            "descricao" : "Uma marca inovadora",
            "id" : 1,
            "nome" : "Show de Marca"
         },
         "id" : 2,
         "fornecedor" : {
            "cnpj" : "********",
            "id" : 1,
            "endereco" : "Rua 1",
            "email" : "fornecedor1@********",
            "telefone" : "111111****",
            "nome" : "Fornecedor ForAll"
         },
         "unidade" : "unidade"
      }
   ],
   "totalElements" : 1,
   "empty" : false
}
 ```
 
 ## Contribuindo com este projeto

Para contribuir com este projeto, siga estes passos:

1. Faça um 'Fork' deste repositório;
2. Crie um 'Branch' com o código no terminal: `git checkout -b feature/<NOME_DO_BRANCH>`;
3. Faça suas alterações e realize o 'add & commit' com o seguinte código no terminal: `git add <arquivos> && git commit -m "mensagem"`, mensagem de commit utilizando [ConventionalCommit](https://www.conventionalcommits.org/en/v1.0.0/);
4. Então, realize o 'push' para o origianl: `git push origin <bootcamp-backend-spring>/<LOCAL>`;
5. Por fim, crie um 'pull request' para este repositório.

Em caso de dúvidas, leia a documentação do GitHub sobre [como criar pull requests](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).
