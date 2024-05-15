# Sistema de Catalogação de Livros Offline

Este sistema permite catalogar e pesquisar livros offline, carregando a base de dados a partir de um arquivo CSV. Além disso, oferece funcionalidades como inserção de novo livro, listagem de autores com quantidade de obras, listagem de livros de determinado autor, listagem de todos os livros catalogados, localização do endereço do livro através do número de e-book, exibição de todos os livros de determinado ano e exclusão de livro através do número de e-book.

## Escolha da Estrutura de Dados: Árvore AVL

Para garantir complexidade média de O(log n) para busca, inserção e remoção, foi escolhida a estrutura de dados conhecida como árvore AVL, uma árvore de busca binária balanceada. Isso garante que operações em uma árvore com n elementos possam ser feitas em O(log n) mesmo no pior caso.

### Árvore AVL

Uma árvore AVL é uma árvore de busca binária em que a diferença entre as alturas das subárvores esquerda e direita de qualquer nó é no máximo 1. Caso contrário, a árvore não está balanceada. As rotações são usadas para balancear a árvore quando necessário.

### Implementação da Árvore AVL

A implementação foi feita com duas classes: Nó e ÁrvoreAVL. Foram utilizadas três árvores: uma para classes Livro e Data, com comparação de inteiros, e outra para a classe Autor, com comparação de strings.

- **Método de Inserção:** Insere um novo livro na árvore AVL.
- **Método de Busca:** Busca um livro na árvore AVL.
- **Método de Remoção:** Remove um livro da árvore AVL.
- **Método para Verificar Existência:** Verifica se um livro existe na árvore AVL.
- **Método para Calcular Altura da Árvore:** Calcula a altura da árvore AVL.
- **Métodos de Rotação:** Realizam rotações para balanceamento da árvore AVL.
- **Método para Retorno da Árvore em Forma de Lista:** Retorna a árvore AVL em forma de lista para facilitar escrita e remoção de dados no arquivo CSV.

A implementação da árvore AVL foi feita exclusivamente para o sistema de catalogação de livros e utiliza conceitos como sobrecarga de tipo para garantir funcionalidades específicas do sistema.

## Estrutura do Projeto

O projeto está organizado em pacotes e classes da seguinte maneira:

### Pacote model

Neste pacote, estão localizadas as classes que representam os modelos de dados do sistema:

- **Livro:** Armazena informações sobre os livros, como número de e-book, título, autor, mês e ano de lançamento, e link para acesso ao livro.
- **Autor:** Possui o nome do autor e uma lista de livros que armazenam todas as obras desse autor.
- **Data:** Contém a data de publicação e uma lista de livros publicados naquele ano específico.

### Pacote controller

Este pacote contém a classe responsável por controlar todas as funcionalidades do sistema e interagir com a base de dados:

- **Database:** Implementa todas as funcionalidades e requisitos do sistema, utilizando árvores AVL para armazenar objetos do tipo Autor e Data. Esta classe possui métodos para ler o banco de dados de texto, adicionar livros, escrever dados na base de dados de texto, gravar todas as buscas feitas pelo sistema em arquivos de texto, buscar objetos do tipo Autor e Data, imprimir todos os autores junto com a quantidade de livros cadastrados, listar os livros publicados por um autor específico, listar os livros publicados em determinado ano, remover um livro da base de dados e buscar o link de acesso do livro pelo número de e-book.

### Classes de Teste

Foram implementados testes unitários para cada funcionalidade do sistema, utilizando JUnit. Os métodos testados incluem a leitura do arquivo de banco de dados, escrita de dados na base de dados, contagem de autores, listagem de livros por autor, listagem de livros publicados em determinado ano e remoção de livros da base de dados. Todos os testes foram executados com sucesso.

## Utilização do Sistema

Para utilizar o sistema, basta instanciar a classe Database e chamar os métodos conforme necessário para realizar as operações desejadas, como adicionar livros, buscar informações, listar autores e livros, entre outras.

## Estrutura do Banco de Dados

O banco de dados é armazenado em formato de arquivo CSV, que contém todas as informações dos livros do sistema. Além disso, são criados arquivos de texto para armazenar o histórico das buscas realizadas pelo sistema.
