#include <unistd.h>
#include <sys/wait.h>
#include <stdio.h>

int main( int argc, char const * argv[])
{

   pid_t pid;

   for(int processo = 1; processo <= 10; processo ++)
    {
        if((pid = fork()) == 0) // cria um novo processo
            {
                //filho
                printf("[filho] pid = %d\n", getpid());
                printf("[filho] ppid = %d\n", getppid());
                printf("[filho] i = %d\n", processo);
                _exit(processo);
            }
    }

    for(int i = 1; i <=10; i++)
    {
        int status;
        pid_t pid = wait(&status); // para que o pai fique à espera que o filho acabe de fazer as coisas
            if (WIFEXITED(status)) // para ver se o filho executou o exit direito ou não
                {
                    printf("%d, foi o ultimo filho status %d\n", pid, status);
                }
            else printf("ERROR\n");
    }
    return 0;
}
