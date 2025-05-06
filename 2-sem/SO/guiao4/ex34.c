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
        close(pd[0]);

        for(int i = 0; i < 1000 ;i++){
        write(pd[1],&i,sizeof(int));
        printf("Child %d writed\n", i);
        }


        close(pd[1]);
        _exit(0);
    }
    else{ 
    //pai
        close(pd[1]);
        int i;

        for(i = 0; i<1000; i++){
        sleep(1);
        read(pd[0], &i,sizeof(int));
        printf("child read x= %d\n", i);
        }

        int status;
        pid_t terminated = wait(&status);
        if(WIFEXITED(status)){
            printf("child %d terminated\n", terminated);
        }
        else{
            printf("error\n");
        }
        close(pd[0]);
    }

    return 0;
}