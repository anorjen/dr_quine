/*
	Comment
*/

#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

#define GRACE(x) int main(void) { int fd = open("Grace_kid.c", O_WRONLY | O_TRUNC | O_CREAT, 0644); if (fd < 0) return (1); PRINT(fd, x); close(fd); return (0); }
#define PRINT(fd, s) dprintf(fd, s, s, 10, 9, 34)
#define SRC "/*%2$c%3$cComment%2$c*/%2$c%2$c#include <stdio.h>%2$c#include <unistd.h>%2$c#include <fcntl.h>%2$c%2$c#define GRACE(x) int main(void) { int fd = open(%4$cGrace_kid.c%4$c, O_WRONLY | O_TRUNC | O_CREAT, 0644); if (fd < 0) return (1); PRINT(fd, x); close(fd); return (0); }%2$c#define PRINT(fd, s) dprintf(fd, s, s, 10, 9, 34)%2$c#define SRC %4$c%1$s%4$c%2$c%2$cGRACE(SRC)%2$c"

GRACE(SRC)
