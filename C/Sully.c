#define _GNU_SOURCE
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

#define FILE "Sully_%d.c"
#define COMPILE "gcc Sully_%d.c -o Sully_%d"
#define RUN "./Sully_%d"
#define SRC "#define _GNU_SOURCE%2$c#include <stdlib.h>%2$c#include <stdio.h>%2$c#include <unistd.h>%2$c#include <fcntl.h>%2$c%2$c#define FILE %4$cSully_%%d.c%4$c%2$c#define COMPILE %4$cgcc Sully_%%d.c -o Sully_%%d%4$c%2$c#define RUN %4$c./Sully_%%d%4$c%2$c#define SRC %4$c%1$s%4$c%2$c%2$cint main(void)%2$c{%2$c%3$cint%3$c%3$ci = %5$d;%2$c%3$cint%3$c%3$cfd;%2$c%3$cchar%3$c*file;%2$c%3$cchar%3$c*compile;%2$c%3$cchar%3$c*run;%2$c%2$c%3$cfile = NULL;%2$c%3$ccompile = NULL;%2$c%3$crun = NULL;%2$c%3$c--i;%2$c%3$casprintf(&file, FILE, i);%2$c%3$cif ((fd = open(file, O_WRONLY | O_TRUNC | O_CREAT, 0644)) > 0)%2$c%3$c{%2$c%3$c%3$cdprintf(fd, SRC, SRC, 10, 9, 34, i);%2$c%3$c%3$cclose(fd);%2$c%3$c%3$casprintf(&compile, COMPILE, i, i);%2$c%3$c%3$cif (system(compile) == 0 && i > 0)%2$c%3$c%3$c{%2$c%3$c%3$c%3$casprintf(&run, RUN, i);%2$c%3$c%3$c%3$csystem(run);%2$c%3$c%3$c%3$cfree(run);%2$c%3$c%3$c}%2$c%3$c%3$cfree(compile);%2$c%3$c}%2$c%3$cfree(file);%2$c%3$creturn (0);%2$c}%2$c"

int main(void)
{
	int		i = 5;
	int		fd;
	char	*file;
	char	*compile;
	char	*run;

	file = NULL;
	compile = NULL;
	run = NULL;
	--i;
	asprintf(&file, FILE, i);
	if ((fd = open(file, O_WRONLY | O_TRUNC | O_CREAT, 0644)) > 0)
	{
		dprintf(fd, SRC, SRC, 10, 9, 34, i);
		close(fd);
		asprintf(&compile, COMPILE, i, i);
		if (system(compile) == 0 && i > 0)
		{
			asprintf(&run, RUN, i);
			system(run);
			free(run);
		}
		free(compile);
	}
	free(file);
	return (0);
}
