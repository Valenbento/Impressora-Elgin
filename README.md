# 🖨️ Sistema de Controle de Impressora Elgin
### Impressora-Elgin
---

## 📘 Sobre o Projeto

Este projeto foi desenvolvido por alunos da disciplina de **Programação Orientada a Objetos** para se comunicar com uma impressora térmica **Elgin i8/i9** usando a biblioteca `E1_Impressora01.dll`.

O sistema é um programa de console em Java: pede **login e senha** (com no máximo 3 tentativas) e mostra um **menu** com operações como imprimir texto, QR Code, código de barras, XML de cupom SAT, abrir a gaveta e tocar o sinal sonoro. Cada parte do programa fica em uma classe própria, usando classes, objetos, atributos, métodos, laços de repetição e tratamento de erros com `try/catch`.

---

## 🧰 Tecnologias Utilizadas

- **Java** (JDK 17 ou superior)
- **IntelliJ IDEA**
- **JNA 5.15.0** (comunicação com a DLL)
- **DLL E1_Impressora01** (SDK da Elgin)
- **Impressora Elgin i8 ou i9** (conectada por USB)
- **Git e GitHub** (controle de versão)

---

## 📁 Estrutura do Projeto

```
/src
   Main.java              → Inicia o programa: faz o login (3 tentativas) e chama o menu
   Usuario.java           → Guarda login e senha e confere se estão corretos
   Menu.java              → Mostra o menu, lê a opção e chama a operação escolhida
   Impressora.java        → Guarda os dados da conexão e tem um método para cada operação
   ImpressoraDLL.java     → Ligação do Java com a DLL da Elgin (fornecido pelo professor)
/Bibliotecas E1 Impressora → DLLs da Elgin (x64 e x86)
/libs Java                → jna-5.15.0.jar
XMLSAT.xml                → Cupom SAT de exemplo
CANC_SAT.xml              → Cancelamento de cupom SAT de exemplo
```

---

## ⚙️ Instalação e Execução

### 1. Baixar o projeto
1. Acesse o repositório no GitHub.
2. Clique em **Code → Download ZIP**.
3. Extraia o arquivo.

### 2. Abrir no IntelliJ IDEA
1. **File → Open** e escolha a pasta extraída.
2. Em **File → Project Structure → Project**, escolha um JDK (17 ou mais novo).
3. Em **File → Project Structure → Libraries**, confirme que o `jna-5.15.0.jar` está adicionado (se não estiver: **+ → Java** e escolha `libs Java/jna-5.15.0.jar`).
4. Conecte e ligue a impressora por USB.
5. Abra `Main.java` e clique em ▶️ **Run**.

> O **Working directory** da execução deve ser a pasta principal do projeto (onde está a pasta `Bibliotecas E1 Impressora`). Sem isso a DLL não é encontrada.

---

## 🔐 Login

- **Usuário:** `admin`
- **Senha:** `1234`
- São permitidas **3 tentativas**. A cada erro o programa mostra quantas restam; ao errar 3 vezes, ele avisa e encerra.

---

## 📋 Funcionalidades do Menu

| Opção | O que faz |
|---|---|
| 1 | Configurar conexão (tipo, modelo, porta e parâmetro) |
| 2 | Abrir conexão com a impressora |
| 3 | Fechar conexão |
| 4 | Imprimir texto (com quantidade de cópias) |
| 5 | Imprimir QR Code |
| 6 | Imprimir código de barras |
| 7 | Imprimir XML SAT (`XMLSAT.xml`) |
| 8 | Imprimir XML de cancelamento SAT (`CANC_SAT.xml`) |
| 9 | Abrir a gaveta |
| 10 | Sinal sonoro (bip) |
| 11 | Avançar papel |
| 12 | Ver status do papel |
| 0 | Sair |

As opções 3 a 12 só funcionam com a conexão aberta. Se ela estiver fechada, o programa avisa **"Conexão fechada. Abra a conexão antes."** e volta ao menu, sem pedir nenhum dado de impressão.

---

## 🧪 Testes Realizados

O programa foi executado no IntelliJ IDEA com a impressora conectada por USB. Os cenários testados e o comportamento esperado em cada um:

| Teste | O que deve acontecer |
|---|---|
| Login com senha errada 3 vezes | Mostra as tentativas restantes e encerra o programa |
| Login correto (`admin` / `1234`) | Mostra "Login realizado!" e abre o menu |
| Opção de impressão sem abrir a conexão | Avisa "Conexão fechada. Abra a conexão antes." e volta ao menu |
| Abrir conexão (opção 2) | Mostra "Conexao aberta com sucesso!" |
| Sinal sonoro (opção 10) | A impressora apita a quantidade de vezes digitada |
| Imprimir texto, QR Code e código de barras (opções 4, 5 e 6) | A impressora imprime e corta o papel |
| Imprimir XML SAT e cancelamento (opções 7 e 8) | A impressora imprime o cupom de exemplo |
| Abrir gaveta, avançar papel e status do papel (opções 9, 11 e 12) | Executa a ação e mostra a mensagem de sucesso ou o status |
| Digitar letras onde se espera número | O programa pede o número de novo, sem travar |
| Fechar conexão (opção 3) e sair (opção 0) | Fecha a conexão e encerra o programa |

---

## 📚 Documentação Adicional

- Manual da impressora Elgin
- Documentação do SDK E1_Impressora

---

## 👥 Autores


- Anna Luiza Zamith
- Beatriz Furtado
- Maria Clara Fernandes
- Valentina Bento Dias