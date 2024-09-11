x = [1 3  4  7  9  10 11];
f = [8 10 10 13 18 20 26];

A = [sum(1./x.^2), sum(1./x .* sin(x)), sum(1./x .* x.^2);
     sum(sin(x) .* 1./x), sum(sin(x).^2), sum(sin(x) .* x.^2);
     sum(x.^2 .* 1./x), sum(x.^2 .* sin(x)), sum(x.^4)];

B = [sum(f .* 1./x);
     sum(f .* sin(x));
     sum(f .* x.^2);];

C = A\B;

m = C(1)*1./x+C(2)*sin(x)+C(3)*x.^2; % Modelo
residuo = f - m; % Resido ponto a ponto
S = sum(residuo.^2); % Somatório do quadrado do residuo
xaux = 1:0.01:12;
maux = C(1)*1./xaux+C(2)*sin(xaux)+C(3)*xaux.^2; % Avaliar no modelo

plot(x,f,'or');
hold on;
plot(xaux,maux,'b')

