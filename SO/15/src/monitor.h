#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h> /* O_RDONLY, O_WRONLY, O_CREAT, O_* */

#include "table.h"

/*
 * Função auxilar que conta o número de "\n"
 */
int count_nl(char *string);
/*
 * Função auxilar que conta o número de digitos
 */
int countDigits(int num);
/*
 * Função auxilar que lê um determinado ficheiro e coloca a informação em memória
 */
void parseFile(int fd);

/*
 * Função que lê os ficheiros que estão numa diretoria e carrega os mesmo em memória
 */
int bootServer(char *directoryOr);