function [f] = mar73(x)
%sistema de duas equações
f(1) = x(1)^2+x(2)^2-1;
f(2) = sin(pi*x(1)/2)+x(2)^3;
end

