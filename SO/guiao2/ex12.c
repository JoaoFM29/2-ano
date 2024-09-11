#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>

int main( int argc, char const * argv[])
{
   // pid_t pid = getpid();
   //pid_t ppid = getppid();
   //printf("pid: %d\nppid: %d\n", pid, ppid);

   pid_t pid;
   int i = 0 ;
   if((pid = fork()) == 0) // cria um novo processo
    {
        //filho
        printf("[filho] pid = %d\n", getpid());
        printf("[filho] ppid = %d\n", getppid());
        i++;
        printf("[filho] i = %d\n", i);
        _exit(0);
    }
   else 
    {
        //pai
        printf("[pai] pid = %d\n", getpid());
        printf("[pai] ppid = %d\n", getppid());
        printf("[pai] pid filho = %d\n", pid);
        i--;
        printf("[pai] i = %d\n", i);

        int status;
        pid_t terminated = wait(&status); // para que o pai fique à espera que o filho acabe de fazer as coisas

        if (WIFEXITED(status))
        {
            printf("[pai] filho %d terminated\n", terminated);
        }
        else{
            printf("ERROR\n");
        }
        
        
    }
    return 0;
}
