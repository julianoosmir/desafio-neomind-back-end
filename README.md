# desafio-neomind-back-end

## Requisitos não funcionais para executar o projeto

- Banco de dados Sql Server
- Java 11
- Maven
- TomEE

## EndPoint do projeto

o unico endpoint no do projeto e do fornecedor pode fazer Requisições GET, POST, PUT e DELETE

```
    http://localhost:8080/desafio_war_exploded/api/fornecedor/
```


## Configurar o TomEE 

filter cors configuration( adicionar no web.xml ) :

```
 <filter>
        <filter-name>CorsFilter</filter-name>
        <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
        <init-param>
            <param-name>cors.allowed.origins</param-name>
            <param-value>*</param-value> <!-- Permitir todas as origens -->
        </init-param>
        <init-param>
            <param-name>cors.allowed.methods</param-name>
            <param-value>GET,POST,HEAD,OPTIONS,PUT,DELETE</param-value> <!-- Métodos HTTP permitidos -->
        </init-param>
        <init-param>
            <param-name>cors.allowed.headers</param-name>
            <param-value>Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization</param-value> <!-- Cabeçalhos permitidos -->
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CorsFilter</filter-name>
        <url-pattern>/*</url-pattern> <!-- Aplicar o filtro a todas as URLs -->
    </filter-mapping>

```

Conexão com o banco de dados (adicinar no tomee.xml): 

```
    <Resource id="DesafioDataSourceJNDI" type="javax.sql.DataSource">
        JdbcDriver com.microsoft.sqlserver.jdbc.SQLServerDriver
        JdbcUrl jdbc:sqlserver://localhost:1433;databaseName=desafio;encrypt=true;trustServerCertificate=true;
        UserName sa
        Password admin123456!
        JtaManaged true
    </Resource>

``` 
## Entidade Fornecedor

run script in database sql server

```
DROP TABLE IF EXISTS dbo.fornecedor
go
CREATE TABLE fornecedor (
                            id int IDENTITY(1, 1) NOT NULL primary key,
                            name varchar(255) NOT NULL,
                            email varchar(255) NOT NULL,
                            cnpj varchar(20) NOT NULL,
                            comment varchar(255) NOT NULL,

);
go
``` 

