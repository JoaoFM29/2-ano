#include <unistd.h>/* chamadas ao sistema: defs e decls essenciais */
#include <sys/wait.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char const *argv[]){

    int in = open("/etc/passwd", O_RDONLY, 0600);
    int out = open("saida.txt", O_WRONLY | O_CREAT, 0600);
    int err = open("erros.txt", O_WRONLY | O_CREAT, 0600);
    
    int original_stdout = dup(1); // aponta para onde o 1 está a apontar

    dup2(in, 0); // o 0 passa a apontar para o ficheiro in
    close(in);

    dup2(out, 1);
    close(out);

    dup2(err, 2);
    close(err);

    ssize_t bytes;
    char* buffer[1024];

    while( (bytes = read(0,buffer, 1024)) > 0){
        write(1, buffer, bytes);
    }

    dup2(original_stdout, 1);
    close(original_stdout);

    printf("terminei\n");
    return 0;
}