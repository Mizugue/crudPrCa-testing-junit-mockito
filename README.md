API REST - Testes com JUnit e Mockito

Este projeto é uma API REST desenvolvida com Spring Boot, implementando um CRUD simples para Categorias e Produtos. O foco principal, no entanto, é a prática de testes automatizados utilizando JUnit e Mockito, cobrindo as camadas de repositório, serviço e controlador.
🚀 Tecnologias Utilizadas

    Spring Boot – Framework para desenvolvimento de APIs REST.
    JUnit – Framework para testes unitários.
    Mockito – Biblioteca para criação de mocks e simulação de dependências.
    H2 Database – Banco de dados em memória utilizado para testes de integração.

🔍 Objetivo

Este projeto tem como propósito demonstrar boas práticas de testes automatizados, abordando testes unitários, de integração e de repositório. Embora o CRUD esteja implementado, o principal foco é garantir a cobertura de testes em diferentes camadas da aplicação.
🧪 Tipos de Testes Implementados
✅ Testes Unitários

    Validam a lógica de negócio isoladamente.
    Utilizam Mockito para simular dependências e evitar interações com o banco de dados real.

✅ Testes de Integração

    Utilizam @SpringBootTest para carregar o contexto da aplicação.
    Testam a integração entre controllers, services e repositórios.

✅ Testes de Repositório

    Utilizam o banco de dados em memória H2.
    Validam o funcionamento das consultas e persistência de dados.

📌 Este projeto é ideal para quem deseja aprender a escrever testes eficientes e confiáveis em aplicações Spring Boot!