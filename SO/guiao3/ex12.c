#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>

int main (int argc, char const * argv[]){

    pid_t pid;
    if ((pid = fork()) == 0){
    execlp("ls","ls","-l",NULL);
    printf("error\n");
    _exit(1);
    }else{

        int status;
        pid_t pid_termin = wait(&status);
        if (WIFEXITED(status)){

            printf("child %d terminated with exit code %d\n", pid_termin,WEXITSTATUS(status));

        }
        else{
            printf("error\n");
        }

    }


    return -1;
}