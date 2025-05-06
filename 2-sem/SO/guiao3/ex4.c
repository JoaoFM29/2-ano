#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


static int nr_space(char *buf){
    int nr = 0;
    for(int i=0; buf[i]!='\0'; i++){

        if(buf[i]==' ') nr +=1;

    }

    return nr;
}

void my_system(char* buffer){

    int malloc_size = nr_space(buffer)+3;

    char **arguments = malloc(sizeof(char*) * malloc_size);
    arguments[0] = strdup("/bin/");
    int i;
    for (i = 0; i < malloc_size-1; i++){

        if (i == 0){
            
            strcat(arguments[0],strsep(&buffer," "));
            
            continue;

        }
        if (i==1){

            arguments[1] = strdup(arguments[0]);
            continue;

        }
        arguments[i] = strdup(strsep(&buffer," "));

    }
    arguments[i] = NULL;



    pid_t pid;
    if ((pid = fork()) == 0){
        //filho
        execv(arguments[0],arguments+1);
        printf("error1\n");
        _exit(1);

    }
    int status;
        pid_t pid_termin = wait(&status);
        if (WIFEXITED(status)){

            printf("child %d terminated with exit code %d\n", pid_termin,WEXITSTATUS(status));

        }
        else{
            printf("error2\n");
        }
}

void my_system2(char* buffer){

    int malloc_size = nr_space(buffer)+2;

    char **arguments = malloc(sizeof(char*) * malloc_size);
    int i;
    for (i = 0; i < malloc_size-1; i++){

        arguments[i] = strdup(strsep(&buffer," "));

    }
    arguments[i] = NULL;



    pid_t pid;
    if ((pid = fork()) == 0){
        //filho
        execvp(arguments[0],arguments);
        printf("error1\n");
        _exit(1);

    }
    int status;
        pid_t pid_termin = wait(&status);
        if (WIFEXITED(status)){

            printf("Process terminated with exit code %d\n",WEXITSTATUS(status));

        }
        else{
            printf("error2\n");
        }
    free(arguments);
}


int main (int argc, char const * argv[]){

    my_system2(strdup("ls -l"));
    return 0;
}