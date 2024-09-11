#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include "readln.h"

#define MAX_BUFFER 4096

int main()
{
    int line_counter = 0;
    char buffer[MAX_BUFFER];
    int bytes_read = 0;
    int newline = 1;

    while((bytes_read = readln(STDIN_FILENO, buffer, MAX_BUFFER))>0)
        {
            char line_number[10] = "";
            if(newline && buffer[0] != '\n')
                {
                    snprintf(line_number, 10, "%d:", line_counter);
                    write(STDOUT_FILENO, line_number, sizeof(line_number));
                    line_counter++;
                }
            write(STDOUT_FILENO, buffer, bytes_read);

            if(buffer[bytes_read -1] !='\n')
                {
                    newline = 0;
                }
            else
                {
                    newline = 1;
                }
        }
        return 0;
}