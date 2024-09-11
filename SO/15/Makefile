all: folders server client

server: bin/monitor
client: bin/tracer

folders:
	@mkdir -p src obj bin tmp

bin/monitor: obj/monitor.o obj/table.o obj/message.o obj/util.o
	gcc -g obj/monitor.o obj/table.o obj/message.o obj/util.o -o bin/monitor

obj/monitor.o: src/monitor.c src/monitor.h src/util.h
	gcc -Wall -g -c src/monitor.c -o obj/monitor.o

obj/table.o: src/table.c src/table.h src/util.h
	gcc -Wall -g -c src/table.c -o obj/table.o

obj/message.o: src/message.c src/message.h src/util.h
	gcc -Wall -g -c src/message.c -o obj/message.o

obj/util.o: src/util.c src/util.h
	gcc -Wall -g -c src/util.c -o obj/util.o

bin/tracer: obj/tracer.o obj/message.o obj/util.o
	gcc -g obj/tracer.o obj/message.o obj/util.o -o bin/tracer

obj/tracer.o: src/tracer.c src/tracer.h src/message.h src/util.h
	gcc -Wall -g -c src/tracer.c -o obj/tracer.o

clean:
	rm -f obj/* tmp/* bin/*

clean_temp:
	rm -f tmp/*
