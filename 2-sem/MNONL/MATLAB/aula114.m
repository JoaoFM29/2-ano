x = [1 3  4  7  9  10 11];
f = [8 10 10 13 18 20 26];

p1 = polyfit(x,f,1);
[p2,S2] = polyfit(x,f,2);
plot(x,f,'or');
hold on;
xaux = 1:0.01:12;
yaux = polyval(p1,xaux);
plot(xaux,yaux,'b')
hold on;
yaux2 = polyval(p2,xaux);
plot(xaux,yaux2,'r')