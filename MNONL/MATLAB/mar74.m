function [f] = mar74(x)
%MAR74 Summary of this function goes here
%   Detailed explanation goes here
f(1) = 0.7 * sin(x(1)) + 0.2 * cos(x(2)) - x(1);
f(2) = 0.7 * cos(x(1)) - 0.2 * sin(x(2)) - x(2);
end

