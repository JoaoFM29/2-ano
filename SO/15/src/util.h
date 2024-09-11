#include <string.h>
#include <stdio.h>
#include <stdlib.h>
/*
 * Função que remove caracteres que estão a mais no íncio e no fim da string
 */
void trimString(char *str);
/*
 * Função que conta o número de espaços
 */
int nr_space(char *buf);
/*
 * Função que conta o número de programas
 */
int nr_pro(char *buf);
/*
 * Função que cria uma só string com os Pids recebidos por argumento
 */
char *concatPids(int argc, char **argv, int st);
/*
 * Função que adciona .txt no fim de um buffer
 */
void addTxt(char *buffer);
/*
 * Função que constroi um path para os ficheiros tendo em conta um path
 */
char *buildPath(const char *directory, char *filename);