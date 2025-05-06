#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int mycp(char* file_input, char* file_output,int size)
{
    int fd_input = open(file_input, O_RDONLY);
    if (fd_input < 0)
    {
        perror("erro ao abrir ficheiro de entrada\n");
        return -1;
    }

    int fd_output = open(file_output, O_WRONLY|O_CREAT|O_TRUNC,0640);
    if (fd_output < 0)
    {
        perror("erro ao abrir ficheiro de saída\n");
        return -1;
    }

    //char buf[size];
    char* buf = (char*) malloc (sizeof(char)*size);

    ssize_t bytes_read;
    ssize_t bytes_written;
    int nsyscalls = 0;

    while((bytes_read = read(fd_input, buf,size)) > 0)
    {
        bytes_written = write(fd_output,buf,bytes_read);
        nsyscalls += 2;
    }

    printf ("nsyscalls: %d\n",nsyscalls);
    close(fd_input);
    close(fd_output);
    free(buf);
    
    return 0;
}

int main(int argc, char** argv)
{
    printf ("argc = %d\n",argc);
    for (int i=0;i<argc;i++)
    {
        printf("argv[%d] = %s\n",i,argv[i]);
    }

    if (argc<4)
    {
        printf("usage: ./mycp <input> <output> <size>\n");
        return -1;
    }
    mycp (argv[1],argv[2],atoi(argv[3]));
    return 0;
}