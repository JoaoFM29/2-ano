x = [1 3 4 7 9 10 11 14 15];
y = [6 10 5 13 18 16 25 18 14];
res_l = trapz(x,y);
format long;
%[res_2, np2] = quad('mar75func', 0, 1, 1.0e-12)
%[res_3, np3] = quad('mar75func2', 0, 8)
%[res_3b, np3b] = quad('mar75func2', 0, 8, 1.0e-15)


