% Conjunto de pontos para o eixo x e y, respetivamente.
% X - Jornadas Y - Golos
x = [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29];
y = [0 1 1 1 3 0 3 0 0 1 0 0 0 0 0 1 0 1 0 2 0 0 0 1 0 0 0 0 1];

% Ponto de interpolação a adicionar futuramente.
x_new = 30;

% Divide se os dados num grupo de treino e teste para evitar que o programa se
% adapte demais aos dados de treino e depois não consiga fazer previsões adequadas de novos dados.

% randperm - permuta aleatoriamente números de 1 a (length x).
% ex: randperm(5) pode retornar o conjunto [3, 5, 1, 4, 2].
idx = randperm(length(x));

% Guarda num vetor 80% dos números do indice anterior para treinar o programa.
train_idx = idx(1:floor(length(idx)*0.8)); % floor -> arredondado às unidades.

% Guarda os restantes 20%, para testar o mesmo.
test_idx = idx(length(train_idx)+1:end); 

% Guarda os valores de x do vetor train_idx.
x_train = x(train_idx);

% Guarda os valores de y do vetor train_idx.
y_train = y(train_idx);

% Guarda os valores de x do vetor test_idx.
x_test = x(test_idx);

% Guarda os valores de y do vetor test_idx.
y_test = y(test_idx);

% Vetor com números aleatórios para testar a interpolação.
num_points_to_test = [2,3,4,5,6,7,8,16];

% Cria um vetor ´rmse´ com o tamanho igual ao de ´num_points_to_teste´, preenche a
% zero com a função 'zeros()' e através do parâmetro 1 na função, o vetor 
% criado como coluna, invés de uma linha (facilitar calculos futuros).
rmse = zeros(length(num_points_to_test), 1);

% Enquanto i entre 1 e o tamanho do vetor de `num_points_to_test` aplica o código.
for i = 1:length(num_points_to_test)
    n_interp_points = num_points_to_test(i);
    
    % Cria um vetor, x_interp, com pontos igualmente espaçados entre o min e o max de x_train.
    x_interp = linspace(min(x_train), max(x_train), n_interp_points);
    
    % Calcula os valores correspondentes de y para cada ponto de interpolação x_interp.
    y_interp = interp1(x_train, y_train, x_interp, 'pchip'); 
    % pchic é um método de interpolação polinomial cúbica, muito util quando os dados apresentam variações bruscas
    % pois evita que se crie oscilações ou saltos nos dados interpolados ao usar curvas suaves.
    
    % interp1 é usada para interpolar(encontrar) cada valor de y_interp no respetivo x_interp,
    % criando uma curva suave que passa por esses pontos.
    % Depois esta é usada para extrapolar (processo de estimar ou prever um valor desconhecido) 
    % os valores da curva suave para o conjunto de valores x_test, produzindo os valores previstos y_pred.
    y_pred = interp1(x_interp, y_interp, x_test, 'pchip');

    % Cálculo do erro quadrático em cada ponto interpolado.
    rmse(i) = sqrt(mean((y_pred - y_test).^2));
    
    % Verifica se o número de pontos usados para a interpolação é maior que
    % o número de pontos existentes no vetor x_train, se for, saí.
    if n_interp_points > length(x_train)
        break;
    end
end


% Plot the results
figure; % Cria janelas para mostrar os gráficos
% Plota a variável rmse no eixo y e a variável num_points_to_test no eixo
% x, marca os pontos com 'o' e conecta-os com uma linha.
plot(num_points_to_test, rmse, 'o-'); 
xlabel('Number of interpolation points'); % Legenda do Eixo x
ylabel('RMSE'); % Legenda do eixo y
title('Cross-validation results');
