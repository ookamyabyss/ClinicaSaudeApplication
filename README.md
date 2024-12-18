# ClinicaSaudeApplication

Alterações realizadas - 17/12/2024

Descrição das Alterações Realizadas
1. Correção na Criação de Procedimento
Ajustamos a classe Procedimento para aceitar o enum Especialidade, garantindo que a especialidade seja corretamente atribuída no momento da criação do procedimento. A especialidade agora é um dos atributos obrigatórios do procedimento, utilizando a enumeração definida (PEDIATRIA, DERMATOLOGIA, ENDOCRINOLOGIA, OUTRA).
2. Ajustes no Método main
O método main foi ajustado para garantir a criação de um objeto Procedimento com a especialidade correta, além de tratar corretamente a instância de planos de saúde (como Bradesco, Unimed, Amil, etc.) usando a PlanoSaudeAdapterFactory.
Corrigimos a inicialização de um procedimento e a associação com o paciente, permitindo que o código funcione sem erros.
3. Testes de Adapters de Plano de Saúde
Foram testados os métodos de autorização, cálculo de coparticipação e cobrança para os diferentes planos de saúde (Bradesco, Unimed, Amil), usando os adapters para cada plano.
O código agora consegue simular a autorização de um procedimento e calcular os valores de coparticipação e cobrança de acordo com as regras de cada plano de saúde.
