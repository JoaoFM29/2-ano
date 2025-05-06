%exercicio 1
x1 = [1 1];

op = optimset("TolX", 1.0e-3,'display', 'iter');
[x, f, exitflag,output] = fminsearch(@NM, x1, op);

%exercicio 2
n = 5;
i = 1:n;
x2(i) = i - (n/2+0.5);

op = optimset("TolX", 1.0e-20,'display', 'iter', 'MaxFunEvals', 10000, 'MaxIter', 10000);
[x, f, exitflag,output] = fminsearch(@NM2, x2, op)

function f = NM(x)
f = max(abs(x(1)), abs(x(2)-1));

end

function f = NM2(x)
n = length(x); %comprimento do x
f = n * max(x) - sum(x);

end
