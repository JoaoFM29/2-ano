n = 5;
i = 1:n;
x1(i) = i -(n/2-0.5);
op = optimset('display', 'iter');
[x, f, exitflag,output] = fminsearch(@NM_max, x1, op)

function [f] = NM_max(x)
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
f = prod(x)-min(x);
end