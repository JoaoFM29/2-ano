function [f] = mar75func2(x)
f = exp(-2 * x).*(x.^2) -sin((x+7)./(x+1));
end