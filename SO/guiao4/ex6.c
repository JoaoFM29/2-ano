#include <unistd.h>/* chamadas ao sistema: defs e decls essenciais */
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct MA {
    int linha;
    int rep;

};

int procura(int matriz[4][10], int num, int l, int c){
    int pd[2];
    pipe(pd);
    //pipe[0] = leitura
    //pipe[1] = escrita

    pid_t pid;
    struct MA m;
    for(int i = 0; i<l;i++){
        if((pid = fork())==0){
            //filho
            m.linha = i+1;
            m.rep = 0;
            printf("Child[%d] procura na linha %d\n", getpid(), i+1);
            close(pd[0]);
                for(int j = 0; j < c; j++){
                    if(matriz[i][j] == num){
                        m.rep ++;
                }
            }
            write(pd[1], &m, sizeof(struct MA)); //escreve na matriz
            close(pd[1]); 
            _exit(0);
        }
    }
    for(int i = 1; i<=l;i++){
        //pai
        close(pd[1]);
        close(pd[0]);
        while(read(pd[0], &m,sizeof(struct MA))>0){
        printf("O numero %d aparece na linha %d %d vezes\n", num, m.linha, m.rep);
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


int main(int argc, char const* agrv[]){

    int matriz[4][10] = {{1,77,7,1,1,1,1,1,1},
                        {1,3,1,1,1,1,1,1,1},
                        {1,1,1,1,1,7,7,1,1},
                        {1,1,7,1,1,1,2,1,1}};
    int num = 7;

    return procura(matriz,num, 4, 10);
}