#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h> /* O_RDONLY, O_WRONLY, O_CREAT, O_* */

#include "message.h"
#include "util.h"

/*
 * Função auxiliar que executa um processo passado por argumento tendo em conta os descritores
 * também passados como argumentos
 */
void execute_command(char **args, int read_fd, int write_fd);
/*
 * Função que executa um único programa
 */
void executeU(char *buffer);
/*
 * Função que executa uma pipe line de programas com ajuda da "execute_command"
 */
void executeP(char *buffer);
/*
 * Função que executa a funcionalidade "stats-time"
 */
void executeStatusTime(char *list);
/*
 * Função que executa a funcionalidade "stats-command"
 */
void executeStatusCommand(char *list, char *progName);
/*
 * Função que executa a funcionalidade "stats-uniq"
 */
void executeStatusUniq(char *list);
/*
 * Função que executa a funcionalidade "status"
 */
void executeStatus();
