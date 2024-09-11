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


void executeU (char*buffer){

    // inciar o comando
    pid_t pid;

    // tirar o time stamp primerio
    int malloc_size = nr_space(buffer)+2;
    // Criacao de argumentos para enviar ao monitor
    char **arguments = malloc(sizeof(char*) * malloc_size);

    // Povoar o array de argumentos do filho
    char *pr_name = strdup(buffer);
    int i;
    for (i = 0; i < malloc_size-1; i++){

        arguments[i] = strdup(strsep(&buffer," "));

    }

    arguments[i] = NULL;
}

int main(int argc, char const *argv[]){

    char* commands[] = {
        "ls -l",
        "cut -f7 -d:",
        "uniq",
        "wc -l",

    };

    int num_comands = 4;
    int pipes[num_comands-1][2];


    for(int i = 0; i<num_comands; i++){
        pipe(pipes[i]);

            if (i == 0) {
                if (fork() == 0) {
                    close(pipes[i][0]);
                    dup2(pipes[i][1], 1);
                    close(pipes[i][1]);

                    int malloc_size = nr_space(commands[i]) + 2;
                    char **arguments = malloc(sizeof(char*) * malloc_size);
                    char *pr_name = strdup(commands[i]);
                    if (pr_name == NULL) {
                        perror("strdup");
                        _exit(-1);
                    }

                    int j;
                    for (j = 0; j < malloc_size-1; j++) {
                        arguments[j] = strdup(strsep(&pr_name, " "));
                        if (arguments[j] == NULL) {
                            perror("strdup");
                            _exit(-1);
                        }
                    }
                    arguments[j] = NULL;
                    execvp(arguments[0], arguments);
                    perror("execvp");
                    _exit(-1);
                }
            }

        else if(i+1 == num_comands){
                if(fork()==0){
                    close(pipes[i-1][1]);
                    dup2(pipes[i-1][0],0);
                    close(pipes[i-1][0]);

                    int malloc_size = nr_space(commands[i]) + 2;
                    char **arguments = malloc(sizeof(char*) * malloc_size);
                    char *pr_name = strdup(commands[i]);
                    if (pr_name == NULL) {
                        perror("strdup");
                        _exit(-1);
                    }

                    int j;
                    for (j = 0; j < malloc_size-1; j++) {
                        arguments[j] = strdup(strsep(&pr_name, " "));
                        if (arguments[j] == NULL) {
                            perror("strdup");
                            _exit(-1);
                        }
                    }
                    arguments[j] = NULL;
                    execvp(arguments[0], arguments);
                    perror("execvp");
                    _exit(-1);
                }
        }
        else{
            if(fork() == 0){
                close(pipes[i-1][1]);
                close(pipes[i][0]);
                dup2(pipes[i][1], 1);
                close(pipes[i][1]);
                dup2(pipes[i-1][0], 0);
                close(pipes[i-1][0]);

                int malloc_size = nr_space(commands[i]) + 2;
                char **arguments = malloc(sizeof(char*) * malloc_size);
                char *pr_name = strdup(commands[i]);
                if (pr_name == NULL) {
                    perror("strdup");
                    _exit(-1);
                }

                int j;
                for (j = 0; j < malloc_size-1; j++) {
                    arguments[j] = strdup(strsep(&pr_name, " "));
                    if (arguments[j] == NULL) {
                        perror("strdup");
                        _exit(-1);
                    }
                }
                arguments[j] = NULL;
                execvp(arguments[0], arguments);
                perror("execvp");
                _exit(-1);
            }
            close(pipes[i-1][0]);
            close(pipes[i-1][1]);
        }

    }
    int status;
    wait(&status);
    wait(&status);

    return 0;
}