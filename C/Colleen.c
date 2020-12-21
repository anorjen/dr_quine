#include <stdio.h>

/*
	Comment outside
*/

void	print(const char *s)
{
	printf(s, s, 10, 9, 34);
}

int		main(void)
{
/*
	Comment in
*/
	const char *s = "#include <stdio.h>%2$c%2$c/*%2$c%3$cComment outside%2$c*/%2$c%2$cvoid%3$cprint(const char *s)%2$c{%2$c%3$cprintf(s, s, 10, 9, 34);%2$c}%2$c%2$cint%3$c%3$cmain(void)%2$c{%2$c/*%2$c%3$cComment in%2$c*/%2$c%3$cconst char *s = %4$c%s%4$c;%2$c%3$cprint(s);%2$c%3$creturn (0);%2$c}%2$c";
	print(s);
	return (0);
}
