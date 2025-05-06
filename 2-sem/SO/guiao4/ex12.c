#include <unistd.h>/* chamadas ao sistema: defs e decls essenciais */
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


int main(int argc, char const* agrv[]){
    int pd[2];
    pipe(pd);
    //pipe[0] = leitura
    //pipe[1] = escrita

    pid_t pid;
    if((pid = fork())==0){
    //filho
        close(pd[1]);
        int x;
        read(pd[0],&x,sizeof(int));

        printf("child read x= %d\n", x);
        close(pd[0]);
        _exit(0);
    }
    else{ 
    //pai
        close(pd[0]);
        int x = 123;

        sleep(5);
        write(pd[1], &x,sizeof(int));

        int status;
        pid_t terminated = wait(&status);
        if(WIFEXITED(status)){
            printf("child %d terminated\n", terminated);
        }
        else{
            printf("error\n");
        }
        close(pd[1]);
    }

    return 0;
}