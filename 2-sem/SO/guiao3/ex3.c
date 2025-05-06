#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>

int main (int argc, char const * argv[]){

    pid_t pid;
    for (int i=1; i<argc ; i++ ){

        if ((pid = fork()) == 0){

        //filho
        execlp(argv[i],argv[i],NULL);
        printf("error\n");
        _exit(1);

    }


    }
    for (int i=1; i<argc;i++){

    int status;
        pid_t pid_termin = wait(&status);
        if (WIFEXITED(status)){

            printf("child %d terminated with exit code %d\n", pid_termin,WEXITSTATUS(status));

        }
        else{
            printf("error\n");
        }
    }


}