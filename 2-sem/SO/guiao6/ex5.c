#include <unistd.h>/* chamadas ao sistema: defs e decls essenciais */
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>


static int nr_space(char *buf){
    int nr = 0;
    for(int i=0; buf[i]!='\0'; i++){

        if(buf[i]==' ') nr +=1;

    }

    return nr;
}

int main(int argc, char const *argv[]){
    int pd[2];
    pipe(pd);

    if(fork()==0){
        close(pd[0]);
        dup2(pd[1], 1);
        close(pd[1]);
        execlp("ls", "ls", "/etc", NULL);
        perror("ls:");
        _exit(-1);
    }

    if(fork()==0){
        close(pd[1]);
        dup2(pd[0], 0);
        close(pd[0]);
        execlp("wc", "wc", "-l", NULL);
        perror("wc:");
        _exit(-1);
    }

    close(pd[0]);
    close(pd[1]);


    int status;
    wait(&status);
    wait(&status);

    return 0;
}