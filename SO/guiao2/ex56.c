#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>



int main( int argc, char const * argv[])
{
    int status;
    int matriz[2][10] = {{1,1,1,1,1,1,1,7,1},{1,1,1,1,1,1,1,1,1}};
    pid_t *array = malloc(sizeof(pid_t)*2);
    int l = 0;
    int flag = 0;

    pid_t pid;

    for(int processo = 1; processo <= 2; processo ++)
        {
            if((pid = fork()) == 0) // cria um novo processo
                {
                    //filho a procurar o numero na linha
                    for(int x = 0; x < 10; x++)
                        {
                            if(7 == matriz[processo-1][x])
                            {
                                exit(0);
                            } 
                        }   
                    array[l] = pid;
                    l++;
                    exit(-1);
                }
        }

    for(int i = 1; i<= 2; i ++)
        {
            int status;
            waitpid(array[i],&status,0); // para que o pai fique à espera que o filho acabe de fazer as coisas
            if(WIFEXITED(status)){
                 if(WEXITSTATUS(status) < 255){
                    printf("Encontrou na linha: %d\n", i);
                }
            }
            else printf("ERROR\n");
        }
    return 0;
}