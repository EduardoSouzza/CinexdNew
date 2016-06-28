# CinexdNew


Fazer Cadastro -> clicar botão cadastrar -  preencher informações do cadastro.

Entrar no sistma -> preencher campos do login -> clicar botão entrar

Caso de teste Ingresso: Realizar login -> escolher um filme -> escolher uma data -> escolher um dos horários -> sala -> escolher acento* -> realizar pagamento.
* 1 - verificar se o acento escolhido mudou de estado para ocupado.

Caso de teste Produto:

Cadastrar :
Fluxo básico: Clicar no botão Crud Produto -> Preencher os campos para cadastro -> clicar no botão cadastrar -> cadastrado com sucesso.
Fluxo alternativo 1: Clicar no botão Crud Produto -> Preencher os campos para cadastro -> dados de entrada inválidos -> erro.

Remover :
Fluxo básico: Clicar no botão Crud Produto -> Preencher o campo ID do produto -> clicar no botão remover -> removido com sucesso.
Fluxo alternativo 1: Clicar no botão Crud Produto -> Preencher o campo ID do produto com letras -> clicar no botão remover -> erro.
Fluxo alternativo 2: Clicar no botão Crud Produto -> Preencher o campo ID do produto com ID inexistente no banco de dados -> clicar no botão remover -> erro.

Alterar :
Fluxo básico: Clicar no botão Crud Produto -> Clicar no botão Alterar -> Preencher os campos para alterar -> clicar no botão alterar -> alterado com sucesso.
Fluxo alternativo 1: Clicar no botão Crud Produto -> Clicar no botão Alterar -> Preencher os campos para alterar -> dados de entradas inválidos -> erro.

Caso de teste Combo:

Fluxo básico: Realizar login -> escolher um filme -> comprar um ingresso -> clicar no botão comprar de um produto -> comprado com sucesso.
Fluxo alternativo 1: Realizar login -> escolher um filme -> comprar um ingresso -> clicar no botão adicionar ao combo -> clicar no botão cancelar -> quantidade do produto permanece a mesma de anteriormente.
Fluxo alternativo 2: Realizar login -> escolher um filme -> comprar um ingresso -> clicar no botão adicionar ao combo -> clicar no botão adicionar ao combo -> se quantidade igual a 0 -> mensagem: quantidade indisponível.
Fluxo alternativo 3: Realizar login -> escolher um filme -> comprar um ingresso -> clicar no botão comprar de um produto -> se quantidade igual a 0 -> mensagem: quantidade indisponível.
Fluxo alternativo 4: Realizar login -> escolher um filme -> comprar um ingresso -> clicar no botão adicionar ao combo várias vezes -> verificar com o usuário se deseja todos os produtos adicionados -> se sim, compra realizada ao clicar no botão finalizar -> se não, cancelar compra.

Crud de Filmes

Clicar no botão Crud Cadastro está no menu depois de realizar login -> Preencher os campos para cadastro filmes -> clicar no botão cadastrar -> se estiver tudo ok, cadastrado com sucesso.

Na Listagem de filmes aparecem os botões para deletar ou editar um filme -> Se clicar em editar, as informações serão carregadas em uma tela de cadastra novas informaões -> clicar em salvar para editar com sucesso

Na Listagem de filmes aparecem os botões para deletar ou editar um filme -> Se clicar em deletar, o filme automaticamente será deletado da listagem -> obs: os botões de editar só aparecer se for um administrado do sistema -> para ser um administrado cadastre um usuário chamado admin

Caso de teste para comprar Ingresso

Realizar login -> escolher qual cinema deseja -> escolher qual filme que assistar -> selecionar filme -> comprar ingresso.





