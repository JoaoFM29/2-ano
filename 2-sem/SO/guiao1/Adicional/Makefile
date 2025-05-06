CC = gcc
CFLAGS = -Wall -g

all: readln nl

nl.o: nl.c

aux.o: aux.c

readln.o: readln.c

nl: aux.o nl.o readln.h

readln: readln.o aux.o readln.h

clean:
	rm -f *.o readln nl