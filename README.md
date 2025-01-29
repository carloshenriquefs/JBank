#  :construction: - Project JBank

- Sistema de banking usando Spring Boot;
- Sistema permitira a criação e gestão de carteiras bancárias, incluindo a realização de depósitos, transferências e consultas de extratos.

## 📂 - Estrutura de Pastas:
```
├── jbank
│   ├── controller
|   |   ├── dto
│   ├── entities
│   ├── exception
|   |   ├── dto
│   ├── filter
│   ├── interceptors
│   ├── repository
|   |   ├── dto
│   ├── service
├── test
│   ├── jbank
```

## 📃- Diagrama Funcional:

![jbank1](https://github.com/user-attachments/assets/0cc7b21b-06d9-4a83-95f5-1ebd50cead42)

## 📋- Relacionamentos:

![jbank2](https://github.com/user-attachments/assets/2ac3bdcf-378a-448e-9b23-93b957628a6d)

## ⚙️ - Funcionalidades do Sistema:

- Criar uma Carteira:
  - Permitir a criação de uma carteira bancária com informações como CPF, email e nome do titular. </br>
  
- Encerrar uma Carteira:
  - Permitir o fechamento de uma carteira bancária existente, desde que o saldo esteja zerado.</br>
  
- Depositar Dinheiro:
  - Realizar depósitos de dinheiro em uma carteira existente. Este serviço deve atualizar o saldo da carteira correspondente e registrar os dados na tabela de histórico de depósitos.</br>
    
- Realizar Transferência:
  - Permitir a transferência de fundos de uma carteira para outra. Deve verificar a disponibilidade de saldo suficiente antes de completar a transação.  </br>
  
- Consultar Extrato:
  - Gerar e fornecer um extrato detalhado das transações em uma carteira, incluindo depósitos, transferências recebidas e enviadas, com data e hora.
