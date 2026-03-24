# 📦 Cadastro de Clientes — Java POO

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat&logo=java)
![Status](https://img.shields.io/badge/Status-Em%20desenvolvimento-yellow?style=flat)

Projeto desenvolvido para praticar conceitos de Programação Orientada a Objetos em Java, como parte dos estudos no curso do Isidro.

---

## 🚀 Funcionalidades

- Cadastro de cliente com validação de e-mail, telefone e data de nascimento
- Associação de múltiplos endereços por cliente
- Associação de cartões de pagamento por cliente
- Listagem, busca e remoção de clientes

---

## 🧠 Conceitos aplicados

- Classes e objetos
- Enum (`TipoLogradouro`)
- List e ArrayList (coleções)
- Relacionamento entre entidades (1:N)
- Separação de responsabilidades em pacotes
- Validação de dados com `do/while`
- Métodos com retorno de objetos

---

## 📁 Estrutura do projeto

```
src/
├── app/        → execução do programa (Main)
├── model/      → entidades do sistema (Cliente, Endereco, CartaoPagamento, TipoLogradouro)
├── repo/       → repositório em memória (ClienteRepo)
└── util/       → validações (Validador)
```

---

## ▶️ Execução

1. Clone o repositório
2. Abra o projeto na sua IDE (IntelliJ, Eclipse, VS Code)
3. Execute a classe `Main.java`
4. Interaja pelo menu no console

---

## ⚙️ Pendências

- [ ] Validação de CEP
- [ ] Validação de número e CVV do cartão
- [ ] Validação de mês e ano de validade do cartão
