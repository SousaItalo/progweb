# progweb
Trabalho de Programação Web I, 2015.2


Funcionalidades do sistema:

                  Funcionário | Cliente 
Login                   X     |    X
Consultar acervo        X     |    X
Devolução               X     |         
Renovação               X     |    X
Empréstimo              X     |         
Cadastrar Usuário       X     |

Esquema do Banco de dados: 
Modelo: 
  Usuários:
    Nome
    cpf(PK)
    Senha
    Tipo
    Sexo
    Telefone
    CEP
    Rua
    Cidade
    Estado
  Livros:
    ISBN(PK)
    Nome
    Data de Publicação
    Genêro
    Quantidade
  Escritores:
    Id(PK)
    Nome

Tabelas de relacionamento:
  Emprestimo:
  //Relaciona usuários do tipo cliente, usuários do tipo funcionário e livros.
  Id_Emprestimo(PK)
  Id_Cliente
  Id_Funcionario
  Data_emprestimo
  Data_de_devolução
  Total_de_renovacoes
  Situacao
  Autores:
  //Relaciona Escritores e livros.
  ISBN
  ID_Escritor
