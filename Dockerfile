# Etapa de build com Maven
FROM openjdk:17-slim AS build
RUN apt-get update && apt-get install -y maven

# Diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo pom.xml e mvnw (ou mvnw.cmd) para o container
COPY pom.xml .
COPY mvnw.cmd .
COPY .mvn/ .mvn/
COPY src ./src

# Garantir que o script Maven Wrapper seja executável
RUN chmod +x ./mvnw.cmd

# Baixar dependências Maven antes do build para melhorar o cache
RUN ./mvnw.cmd dependency:resolve

# Rodar o build do projeto
RUN ./mvnw.cmd clean install -DskipTests

# Etapa final com uma imagem mais leve
FROM openjdk:17-jdk-slim

# Diretório de trabalho
WORKDIR /app

# Copiar o JAR gerado do build anterior
COPY --from=build /app/target/*.jar app.jar

# Expor a porta para acesso externo
EXPOSE 8080

# Executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
