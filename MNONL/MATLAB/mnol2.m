x = [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29];
y = [0 1 1 1 3 0 3 0 0 1  0  0  0  0  0  1  0  1  0  2  0  0  0  1  0  0  0  0  1];

% Jornada a prever o número de golos.
x_new = 30;

% Gera 8 pontos (entre o min e o max de x) igualmente espaçados para interpolação.
x_interp = linspace(min(x), max(x), 8);

y_interp = spline(x, y, x_interp);

y_new = spline(x_interp, y_interp, x_new);

% disp - Converte a frase dada como parâmetro numa string para devolver como output.
disp(['The predicted number of goals at ' num2str(x_new) ' is ' num2str(round(y_new))]);