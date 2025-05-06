#include <unistd.h>/* chamadas ao sistema: defs e decls essenciais */
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char const *argv[]){
    int pd[2];
    pipe(pd);

    pid_t pid;
    if((pid = fork())==0){
        close(pd[1]);
        dup2(pd[0], 0);
        close(pd[0]);
        execlp("wc", "wc", NULL);
        perror("wc");
    }
    else{
        close(pd[0]);
        ssize_t bytes;
        char* buffer[1024];
        while((bytes = read(0,buffer, 1024))>0){
            write(pd[1], buffer, 1024);
            printf("escreveu\n");
        }
        close(pd[1]);
        int status;
        wait(&status);
    }
    return 0;
}