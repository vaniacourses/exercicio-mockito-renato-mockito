## ✅ Testes Unitários no Jogo de Dados

Este projeto demonstra como aplicar **testes unitários** em uma aplicação Java que simula um jogo de dados. O objetivo principal foi refatorar um código com **forte acoplamento** e **aleatoriedade** para torná-lo totalmente testável, por meio de **Injeção de Dependência** e uso de **Mocks**.

---

### 🎯 Desafio Inicial

A classe `Jogo` original criava internamente suas dependências (`Jogador` e `Dado`) e utilizava números aleatórios, tornando impossível realizar testes **isolados** e **determinísticos**.

---

### 🛠️ Solução Aplicada

* **Injeção de Dependência**
  A classe `Jogo` foi refatorada para receber suas dependências via construtor, eliminando o acoplamento rígido com `Jogador` e `Dado`.

* **Mocks com Mockito**
  Com o uso da biblioteca **Mockito**, foi possível criar objetos simulados (mocks) e controlar exatamente o comportamento dos métodos, tornando os testes 100% previsíveis e confiáveis.

---

### 🧪 Tecnologias Utilizadas

* **Java 11+**
* **JUnit 5** – framework de testes.
* **Mockito** – framework de mocking para simular dependências.
* **Maven** – gerenciamento de dependências e build.

---

### 📋 Cenários de Teste Cobertos

A classe de testes `JogoTest.java` cobre todas as regras de negócio do jogo:

* ✅ Vitória no primeiro turno (soma 7 ou 11)
* ✅ Derrota no primeiro turno (soma 2, 3 ou 12)
* ✅ Vitória no segundo turno ao repetir o "ponto"
* ✅ Derrota no segundo turno ao obter soma 7 antes do "ponto"
