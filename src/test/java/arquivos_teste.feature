#Author: Felipe Sanches Franqueira
#Keywords Sumary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
# And, But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as as Examples and <placeholder>
#Examples: Container for s table
#Backgorund: List of steps run before each of the scenarios
#""" (Data Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Conta Bancária
@tag
Feature:Cliente faz saque de dinheiro como um cliente,
  eu gostaria de sacar dinheiro em caixa eletrônico,
  para que eu tenha que esperar em uma fila do banco.

  @tag1
    Scenario: Cliente especial com saldo negativo
    Given Um cliente especial com saldo atual de -200 reais
    When for solicitado um saque no valor de 100 reais
    Then deve efetuar o saque e atualizar o saldo da conta para -300 reais
    And check more outcomes

  @tag2
  Scenario Outline: Cliente comum com saldo negativo
    Given Um cliente comum com saldo atual de -200 reais
    When solicitar um saque de 200 reais
    Then não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente