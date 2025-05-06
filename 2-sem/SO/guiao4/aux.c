#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include "aux.h"

struct p {
    int line;
    char buffer[1000];
};

int ler(char* palavra, int n_linhas)
{
    int pd[2];
    pipe(pd);
    //pipe[0] = leitura
    //pipe[1] = escrita

    pid_t pid;

    struct p P;
    P.line = 0;

    FILE *fp = fopen("arquivo.txt", "r");

    int rows = 0;
    for(rows = 0; rows < n_linhas; rows++){
        if((pid = fork())==0){
            //filho
            close(pd[0]);
            P.line = 0;

            printf("Child[%d] procura na linha %d\n", getpid(), rows+1);

            while((fgets(P.buffer, sizeof(P.buffer), fp)) != NULL){
                if((strstr(P.buffer, palavra)) != NULL ){
                    P.line = rows+1;
                    printf("%d\n", P.line);
                    write(pd[1], &P, sizeof(struct p)); 
                } 
            }    
            close(pd[1]); 
            _exit(0);
        }
    }
    fclose(fp);

    for(rows = 0; rows< n_linhas ; rows++){
        //pai
        close(pd[1]);

        while(read(pd[0], &P,sizeof(struct p))>0){
        printf("\nFrase que contêm a palavra chave -> %s\n", P.buffer);
        }

        close(pd[0]);

        int status;
        pid_t terminated = wait(&status);
        if(WIFEXITED(status)){
            printf("child %d terminated\n", terminated);
        }
        else{
            printf("error\n");
        }
    }
    return 0;
}

int linhas(){
    FILE *fp = fopen("arquivo.txt", "r");
    char line[100];
    int n_linhas;
    while (fgets(line, sizeof(line), fp)) {
        n_linhas ++;
    }
    fclose(fp);
    return n_linhas;
}

int main(int argc, char const* agrv[]){

    char *name = "João";
    int n_linhas = linhas();

    return ler(name, n_linhas);
}